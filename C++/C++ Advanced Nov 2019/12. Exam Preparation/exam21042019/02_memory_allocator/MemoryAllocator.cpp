#include "Defines.h"
#include <vector>
#include <iostream>
#include <sstream>
#include <string>

MemoryType getMemoryType(std::string &memoryTypeStr) {
    if (memoryTypeStr == "Single") {
        return MemoryType::SINGLE;
    } else if (memoryTypeStr == "Multiple") {
        return MemoryType::MULTIPLE;
    } else {
        return MemoryType::UNKNOWN;
    }
}

ErrorCode executeCommand(const std::string &command,
                         std::vector<MemoryNode> &memory) {
    std::istringstream iss(command);

    std::string commandType;
    std::string memoryTypeStr;
    int index = -1;

    iss >> commandType >> memoryTypeStr >> index;

    MemoryType memoryType = getMemoryType(memoryTypeStr);


    if (commandType == "Allocate") {
        if (memory[index].memoryType != MemoryType::UNKNOWN) {
            return ErrorCode::MEMORY_LEAK;
        }

        memory[index].memoryType = memoryType;

    } else if (commandType == "Deallocate") {
        if (memory[index].memoryType == MemoryType::UNKNOWN) {
            return ErrorCode::DOUBLE_FREE;
        }

        if (memory[index].memoryType != memoryType) {
            return ErrorCode::ALLOCATE_DEALLOCATE_MISMATCH;
        }

        memory[index].memoryType = MemoryType::UNKNOWN;
    }

    return ErrorCode::EXECUTE_SUCCESS;
}

void printResult(const ErrorCode errorCode,
                 const std::string &command) {

    switch (errorCode) {
        case EXECUTE_SUCCESS:
            std::cout << command << " - success" << std::endl;
            break;
        case MEMORY_LEAK:
            std::cout << command << " - memory leak prevented, will not make allocation" << std::endl;
            break;
        case DOUBLE_FREE :
            std::cout << command << " - system crash prevented, will skip this deallocation" << std::endl;
            break;
        case ALLOCATE_DEALLOCATE_MISMATCH:
            std::cout << command << " - Warning allocate/deallocate mismatch, will skip this deallocation" << std::endl;
            break;
        default:
            break;
    }
}