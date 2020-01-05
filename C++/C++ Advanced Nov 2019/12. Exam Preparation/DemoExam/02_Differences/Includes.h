#ifndef INCLUDES_H
#define INCLUDES_H

#include <vector>
#include <sstream>
#include <utility>

#include "City.h"
#include "CityDiff.h"

std::istream &operator>>(std::istream &stream, City &city) {
    unsigned int censusYear;
    std::string name;
    size_t population;

    stream >> name >> population >> censusYear;

    city = City(censusYear, name, population);

    return stream;
}

CityDiff operator-(City &first, City &second) {
    return CityDiff{first, second};
}

#endif //!INCLUDES_H
