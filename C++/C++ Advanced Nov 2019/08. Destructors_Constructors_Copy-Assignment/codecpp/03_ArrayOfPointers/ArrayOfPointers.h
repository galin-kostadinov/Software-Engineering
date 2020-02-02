#ifndef ARRAYOFPOINTERS_H
#define ARRAYOFPOINTERS_H

#include "Company.h"
#include <vector>
#include <memory>

class ArrayOfPointers {
    std::vector<std::shared_ptr<Company>> companiesPtr;

public:
    ArrayOfPointers() = default;

    void add(Company *c) {
        this->companiesPtr.push_back(std::shared_ptr<Company>(c));
    }

    size_t getSize() const {
        return this->companiesPtr.size();
    }

    Company *get(const size_t index) const {
        return this->companiesPtr.at(index).get();
    }
};

#endif //!ARRAYOFPOINTERS_H
