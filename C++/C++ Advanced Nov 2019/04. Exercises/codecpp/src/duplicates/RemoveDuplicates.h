#ifndef HOMEWORK_REMOVEDUPLICATES_H
#define HOMEWORK_REMOVEDUPLICATES_H

#include <set>

#include "Company.h"

void removeDuplicates(std::list<Company *> &companies) {
    std::list<Company *>::iterator iterator = companies.begin();

    std::set<std::string> founded;

    while (iterator != companies.end()) {
        const std::string &currCompanyName = (*iterator)->getName();

        if (founded.find(currCompanyName) != founded.end()) {
            iterator = companies.erase(iterator);
        } else {
            founded.emplace(currCompanyName);
            iterator++;
        }
    }
}

#endif //HOMEWORK_REMOVEDUPLICATES_H
