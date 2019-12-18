#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

#include "Company.h"

struct orderById {
    inline bool operator()(const Company &a, const Company &b) {
        return (a.getId() < b.getId());
    }
};

struct orderByName {
    inline bool operator()(const Company &a, const Company &b) {
        return (a.getName() < b.getName());
    }
};

void createCompanies(std::vector<Company> &companies) {
    int id;
    std::string name;

    std::string line;
    while (getline(std::cin, line) && line != "end") {
        std::istringstream lineIn(line);
        lineIn >> name >> id;

        companies.emplace_back(Company(id, name));
    }
}

void orderByCriteria(std::vector<Company> &companies, const std::string &compareBy) {
    if (compareBy == "id") {
        std::sort(companies.begin(), companies.end(), orderById());
    } else {
        std::sort(companies.begin(), companies.end(), orderByName());
    }
}

void print(const std::vector<Company> &companies) {
    for (const auto &item : companies) {
        std::cout << item.getName() << ' ' << item.getId() << std::endl;
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    std::vector<Company> companies;

    createCompanies(companies);

    std::string compareBy;
    getline(std::cin, compareBy);

    orderByCriteria(companies, compareBy);

    print(companies);

    return 0;
}