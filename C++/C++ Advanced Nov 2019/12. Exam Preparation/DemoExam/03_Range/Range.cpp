#include <memory>
#include <cstdlib>
#include <cmath>

#include "Range.h"

Range::Range() : rangeFirst(0), rangeLength(0), valueCounts(nullptr) {}

void Range::add(T value) {
    if (this->empty()) {
        this->resize(value, value);
    } else if (value < this->rangeFirst) {
        this->resize(value, this->rangeFirst + this->rangeLength - 1);
    } else if (value >= this->rangeLength + this->rangeFirst) {
        this->resize(this->rangeFirst, value);
    }

    this->valueCounts[this->getIndex(value)]++;
}

size_t Range::getCount(T value) const {
    if (value >= rangeLength + rangeFirst || value < rangeFirst) {
        return 0;
    }

    return this->valueCounts[this->getIndex(value)];
}

bool Range::empty() const {
    return this->valueCounts == nullptr;
}

Range::Range(const Range &other) :
        rangeFirst(other.rangeFirst),
        rangeLength(other.rangeLength),
        valueCounts(Range::copyValues(other)) {}

size_t Range::getIndex(T value) const {
    return static_cast<size_t>(value - this->rangeFirst);
}

Range &Range::operator=(const Range &other) {
    if (this != &other) {
        this->clear();

        this->rangeFirst = other.rangeFirst;
        this->rangeLength = other.rangeLength;

        if(!other.empty()){
            this->valueCounts = Range::copyValues(other);
        }
    }

    return *this;
}

void Range::clear() {
    this->rangeFirst = 0;
    this->rangeLength = 0;
    delete[] this->valueCounts;
    this->valueCounts = nullptr;
}

void Range::resize(T first, T last) {
    T newRangeLength = last - first + 1;

    size_t *newValueCounts = new size_t[newRangeLength]{};

    for (int i = 0; i < newRangeLength; ++i) {
        newValueCounts[i] = this->getCount(first + i);
    }

    this->clear();
    this->rangeFirst = first;
    this->rangeLength = newRangeLength;
    this->valueCounts = newValueCounts;
}

Range::~Range() {
    if (valueCounts != nullptr) {
        this->clear();
    }
}



