#include "IndexedSet.h"
#include <cstdlib>
#include <set>

IndexedSet::IndexedSet() : valuesArray(nullptr) {}

IndexedSet::IndexedSet(const IndexedSet &other) : valuesSet(other.valuesSet), valuesArray(nullptr) {}

void IndexedSet::add(const Value &v) {
    if (this->valuesSet.emplace(v).second && this->valuesArray != nullptr) {
        this->clearIndex();
    }
}

size_t IndexedSet::size() const {
    return this->valuesSet.size();
}

const Value &IndexedSet::operator[](size_t index) {
    if (this->valuesArray == nullptr) {
        this->buildIndex();
    }

    return this->valuesArray[index];
}

IndexedSet &IndexedSet::operator=(const IndexedSet &other) {
    if (this != &other) {
        if (this->valuesArray != nullptr) {
            this->clearIndex();
        }

        this->valuesSet.clear();
        this->valuesSet = other.valuesSet;
    }

    return *this;
}

IndexedSet::~IndexedSet() {
    this->clearIndex();
}

void IndexedSet::buildIndex() {
    size_t size = this->valuesSet.size();

    this->valuesArray = new Value[size];

    size_t index = 0;
    for (const Value &v:this->valuesSet) {
        this->valuesArray[index++] = v;
    }
}

void IndexedSet::clearIndex() {
    delete[]  this->valuesArray;
    this->valuesArray = nullptr;
}