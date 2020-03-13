#include "Statistics.h"
#include <algorithm>
#include <iostream>

bool asc(const PersonInfo &a, const PersonInfo &b) {
    return a.age < b.age;
}

bool desc(const PersonInfo &a, const PersonInfo &b) {
    return a.age > b.age;
}

Statistics &Statistics::operator<<(const PersonInfo &personInfo) {
    if (personInfo.age <= 18) {
        this->minors.push_back(personInfo);
    } else if (personInfo.age <= 62) {
        this->adults.push_back(personInfo);
    } else {
        this->elders.push_back(personInfo);
    }

    return *this;
}

void Statistics::printStatistics() {
    std::sort(elders.begin(), elders.end(), desc);
    std::sort(adults.begin(), adults.end(), asc);
    std::sort(minors.begin(), minors.end(), asc);

    std::cout << "Elders data:" << std::endl;

    for (const PersonInfo &elder:elders) {
        std::cout << elder.firstName << ' ' << elder.lastName << ' ' << elder.height << std::endl;
    }

    std::cout << "Adults data:" << std::endl;

    for (const PersonInfo &adult:adults) {
        std::cout << adult.firstName << ' ' << adult.lastName << ' ' << adult.height << std::endl;
    }

    std::cout << "Minors data:" << std::endl;

    for (const PersonInfo &minor:minors) {
        std::cout << minor.firstName << ' ' << minor.lastName << ' ' << minor.height << std::endl;
    }
}