#ifndef CODECPP_PARSECOMPANIES_H
#define CODECPP_PARSECOMPANIES_H

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <set>

#include "Company.h"

Company *parseUniqueCompanies(std::string input, int &numCompanies,
                              std::string (*uniquenessCriteria)(const Company &)) {

    std::istringstream iss(input);

    int id;
    std::string name;

    std::vector<Company> companiesList;
    std::set<std::string> criteria;

    while (iss >> id && iss >> name) {

        Company company(id, name);

        std::string currCriteria = uniquenessCriteria(company);

        if (criteria.find(currCriteria) == criteria.end()) {
            criteria.emplace(currCriteria);

            companiesList.emplace_back(company);
        }
    }

    numCompanies = companiesList.size();

    Company *companies = new Company[numCompanies];

    for (int i = 0; i < numCompanies; ++i) {
        companies[i] = companiesList[i];
    }

    return companies;
}

#endif //CODECPP_PARSECOMPANIES_H
