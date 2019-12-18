#ifndef CODECPP_REMOVEINVALID_H
#define CODECPP_REMOVEINVALID_H

#include "Company.h"

void removeInvalid(std::list<Company *> &companies) {
    auto it = companies.begin();
    while (it != companies.end()) {
        if ((*it)->getId() < 0) {
            delete *it;
            it = companies.erase(it);
        } else {
            it++;
        }
    }
}

#endif //CODECPP_REMOVEINVALID_H
