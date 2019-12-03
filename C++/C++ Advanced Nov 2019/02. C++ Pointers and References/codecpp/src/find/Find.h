#ifndef CODECPP_FIND_H
#define CODECPP_FIND_H

#include<vector>
#include<algorithm>
#include "Company.h"

Company *find(const std::vector<Company *> &companies, const int searchId) {

    for (size_t i = 0; i < companies.size(); ++i) {
        if (companies[i]->getId() == searchId) {
            return companies[i];
        }
    }

    return nullptr;
}

#endif //CODECPP_FIND_H
