#include "FixedArray.h"

FixedArray::FixedArray(const int arraySize) : BrokenArray(arraySize) {
}

FixedArray::~FixedArray() {
//doesn't have specific behavior different from ~BrokenArray()
}

FixedArray::FixedArray(const FixedArray &other) : BrokenArray(other.getSize()) {
    for (int i = 0; i < other.getSize(); ++i) {
        _array[i] = other._array[i];
    }
}

FixedArray &FixedArray::operator=(const FixedArray &other) {
    if (this != &other) {
        if (_array != nullptr) {
            delete[] _array;
        }

        BrokenArray::operator=(other);

        _array = new int[other.getSize()];

        for (int i = 0; i < other.getSize(); ++i) {
            _array[i] = other._array[i];
        }
    }

    return *this;
}

void FixedArray::addValueToMemory(const int value) {
    for (int i = 0; i < getSize(); ++i) {
        _array[i] += value;
    }
}

int FixedArray::getMemorySumValue() const {
    int sum = 0;

    for (int i = 0; i < getSize(); ++i) {
        sum += _array[i];
    }

    return sum;
}
