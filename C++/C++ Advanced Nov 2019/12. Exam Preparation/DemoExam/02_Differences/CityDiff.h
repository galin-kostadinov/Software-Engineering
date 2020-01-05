#ifndef CITYDIFF_H
#define CITYDIFF_H

#include "City.h"
#include <iostream>
#include <sstream>
#include <utility>

class CityDiff {
    City firstCity;
    City secondCity;
public:
    CityDiff() = default;

    CityDiff(const City &firstCity, const City &secondCity) :
            firstCity(firstCity),
            secondCity(secondCity) {}

    friend std::ostream &operator<<(std::ostream &out, const CityDiff &diff);

};

std::ostream &operator<<(std::ostream &stream, const CityDiff &diff) {
    if (diff.firstCity.getName() == diff.secondCity.getName()) {
        stream << diff.firstCity.getName() << " (" << diff.firstCity.getCensusYear() << " vs. ";
        stream << diff.secondCity.getCensusYear() << ')' << std::endl;
    } else {
        stream << diff.firstCity.getName() << " (" << diff.firstCity.getCensusYear() << ')' << " vs. ";
        stream << diff.secondCity.getName() << " (" << diff.secondCity.getCensusYear() << ')' << std::endl;
    }

    stream << "population: ";

    size_t firstCityPopulation = diff.firstCity.getPopulation();
    size_t secondCityPopulation = diff.secondCity.getPopulation();

    if (firstCityPopulation >= secondCityPopulation) {
        stream << '+' << firstCityPopulation - secondCityPopulation;
    } else {
        stream << '-' << secondCityPopulation - firstCityPopulation;
    }

    stream << std::endl;

    return stream;
}

#endif //!CITYDIFF_H
