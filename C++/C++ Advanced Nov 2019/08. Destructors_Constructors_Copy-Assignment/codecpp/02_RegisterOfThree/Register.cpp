#include <algorithm>

#include "Register.h"

Register::Register(size_t numCompanies) : numAdded(0), companiesArray(new Company[numCompanies]) {}

Register &Register::operator=(const Register &other) {
    if (this != &other) {
        if (this->companiesArray != nullptr) {
            delete[] this->companiesArray;
        }

        this->numAdded = other.numAdded;
        this->companiesArray = new Company[other.numAdded];

        int arrSize = (size_t) other.numAdded;
        for (int i = 0; i < arrSize; ++i) {
            this->companiesArray[i] = other.companiesArray[i];
        }
    }

    return *this;
}

Register::Register(const Register &other) {
    this->numAdded = other.numAdded;
    this->companiesArray = new Company[ this->numAdded];

    int arrSize = (size_t) other.numAdded;
    for (int i = 0; i < arrSize; ++i) {
        this->companiesArray[i] = other.companiesArray[i];
    }
}

void Register::add(const Company &c) {
    this->companiesArray[this->numAdded] = c;
    this->numAdded++;
}

Company Register::get(int companyId) const {
    for (Company *it = companiesArray; it != companiesArray + numAdded; it++) {
        if ((*it).getId() == companyId) {
            return *it;
        }
    }

    return Company();
}

Register::~Register() {
    delete[] this->companiesArray;
}

