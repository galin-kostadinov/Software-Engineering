#ifndef CITYUTILS_H
#define CITYUTILS_H

#include <string>
#include <vector>
#include <map>
#include "City.h"

#include <memory>

City *initCity(std::string name, size_t population) {
    return new City(name, population);
}

std::map<size_t, std::shared_ptr<City>> groupByPopulation(std::vector<const City *> cities, size_t &totalPopulation) {
    std::map<size_t, std::shared_ptr<City>> result;
    totalPopulation = 0;

    size_t size = cities.size();
    for (size_t i = 0; i < size; ++i) {
        size_t population = cities[i]->getPopulation();

        result[population] = std::make_shared<City>(cities[i]->getName(), population);

        totalPopulation += population;
    }

    return result;
}

#endif //!CITYUTILS_H
