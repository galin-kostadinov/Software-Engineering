#include "MemoryPool.h"
#include "Defines.h"
#include "Structs.h"

MemoryPool::MemoryPool(const int memoryPoolSize) : _memoryBuffer(nullptr), _isMemoryBufferOccupied(nullptr),
                                                   _MEMORY_POOL_SIZE(memoryPoolSize) {
    if (memoryPoolSize > 0) {
        _memoryBuffer = new int[_MEMORY_POOL_SIZE]{0};
        _isMemoryBufferOccupied = new bool[_MEMORY_POOL_SIZE]{false};
    }
}

MemoryPool::~MemoryPool() {
    if (_memoryBuffer != nullptr) {
        delete[] _memoryBuffer;
        delete[] _isMemoryBufferOccupied;
        _memoryBuffer = nullptr;
        _isMemoryBufferOccupied = nullptr;
    }
}

ErrorCode MemoryPool::requestMemory(MemoryNode &outNode) {
    const int nodeSize = outNode.size;

    if (nodeSize > _MEMORY_POOL_SIZE) {
        return ErrorCode::REQUEST_FAILURE_BIGGER_THAN_BUFFER;
    }

    int startIndex = -1;
    int freeSpace = 0;
    for (int i = 0; i < _MEMORY_POOL_SIZE; ++i) {
        if (_isMemoryBufferOccupied[i]) {
            startIndex = -1;
            freeSpace = 0;
            continue;
        }

        if (!_isMemoryBufferOccupied[i] && startIndex == -1) {
            startIndex = i;
        }

        freeSpace++;

        if (freeSpace == nodeSize) {
            break;
        }
    }

    if (freeSpace == nodeSize && startIndex >= 0) {
        outNode.bufferStartIndex = startIndex;
        outNode.memory = _memoryBuffer + startIndex;
        this->occupyMemory(outNode);
    } else {
        return ErrorCode::REQUEST_FAILURE_NOT_ENOUGH_MEMORY;
    }

    return ErrorCode::REQUEST_SUCCESS;
}

void MemoryPool::releaseMemory(const MemoryNode &outNode) {
    int size = outNode.size + outNode.bufferStartIndex;

    for (int i = outNode.bufferStartIndex; i < size; ++i) {
        _isMemoryBufferOccupied[i] = false;
    }
}

void MemoryPool::zeroMemoryValue(const MemoryNode &node) {
    int size = node.size + node.bufferStartIndex;

    for (int i = node.bufferStartIndex; i < size; ++i) {
        _memoryBuffer[i] = 0;
    }
}

void MemoryPool::occupyMemory(const MemoryNode &node) {
    int size = node.size + node.bufferStartIndex;

    for (int i = node.bufferStartIndex; i < size; ++i) {
        _isMemoryBufferOccupied[i] = true;
    }
}