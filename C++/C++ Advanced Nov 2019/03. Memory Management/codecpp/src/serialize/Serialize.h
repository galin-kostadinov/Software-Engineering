#ifndef CODECPP_SERIALIZE_H
#define CODECPP_SERIALIZE_H

#include <string>
#include <sstream>
#include <vector>

#include "Company.h"


byte *serializeToMemory(std::string input, size_t &bytesWritten) {
    bytesWritten = 0;

    std::istringstream iss(input);

    std::string line;

    std::vector<Company> companies;

    while (std::getline(iss, line) && line != "end") {
        std::istringstream companiesIss(line);

        Company company;
        companiesIss >> company;
        companies.push_back(company);
        bytesWritten += 1 + company.getName().size() + 2 + company.getEmployees().size() * 2;
    }

    bytesWritten++;

    byte *result = new byte[bytesWritten];

    int index = 0;
    result[index++] = (byte) companies.size();

    for (size_t j = 0; j < companies.size(); ++j) {
        Company company = companies[j];
        result[index++] = (byte) company.getId();

        std::string name = company.getName();
        for (size_t i = 0; i < name.size(); ++i) {
            result[index++] = (byte) name[i];
        }

        result[index++] = '\0';

        std::vector<std::pair<char, char> > employees = company.getEmployees();

        result[index++] = (byte) employees.size();

        for (int k = 0; k < employees.size(); ++k) {
            employees[k];
            result[index++] = (byte) employees[k].first;
            result[index++] = (byte) employees[k].second;
        }
    }

    return result;
}

#endif //CODECPP_SERIALIZE_H
