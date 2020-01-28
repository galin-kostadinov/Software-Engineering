#include <algorithm>

#include "Register.h"

Register::Register(size_t numCompanies) : numAdded(0), companiesArray(new Company[numCompanies]) {}

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

