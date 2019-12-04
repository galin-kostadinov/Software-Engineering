#ifndef CODECPP_TRYPARSE_H
#define CODECPP_TRYPARSE_H

#include <string>

bool tryParse(const std::string &inNumber, int &outNumber) {
    try {
        outNumber = std::stoi(inNumber);
        return true;
    }
    catch (const std::invalid_argument& ia) {
        return false;
    }
}

#endif //CODECPP_TRYPARSE_H
