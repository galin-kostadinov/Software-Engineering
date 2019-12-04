#ifndef CODECPP_ORDEREDINSERTER_H
#define CODECPP_ORDEREDINSERTER_H

#include "Company.h"
#include <vector>
#include <algorithm>

struct increasingOrderById
{
    inline bool operator() (const Company * a, const Company * b)
    {
        return (a->getId() < b->getId());
    }
};

class OrderedInserter {
    std::vector<const Company *> &companies;

public:
    OrderedInserter(std::vector<const Company *> &companies) : companies(companies) {}

    void insert(const Company *c) {
        this->companies.emplace_back(c);
        sort(companies.begin(), companies.end(), increasingOrderById());
    }
};

#endif //CODECPP_ORDEREDINSERTER_H
