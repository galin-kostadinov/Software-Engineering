#ifndef CODECPP_MAKECOMPANY_H
#define CODECPP_MAKECOMPANY_H

#include "Company.h"
#include <memory>

std::shared_ptr<Company> makeCompany(std::vector<std::string> &properties) {
    int id = std::stoi(properties[0]);
    std::string name = properties[1];
    std::vector<std::pair<char, char> > employees;

    for (size_t i = 2; i < properties.size(); ++i) {
        employees.emplace_back(std::make_pair(properties[i][0], properties[i][1]));
    }

    return std::make_shared<Company> (id, name, employees);
}

#endif //CODECPP_MAKECOMPANY_H
