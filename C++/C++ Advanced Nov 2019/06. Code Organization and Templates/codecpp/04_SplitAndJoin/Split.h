#ifndef SPLIT_H
#define SPLIT_H

#include <iostream>
#include <string>
#include <sstream>
#include <vector>

template<typename T>
std::vector<T> split(const std::string &line, const char separator) {
    std::istringstream iss(line);

    std::vector<T> out;
    std::string temp;

    while (getline(iss, temp, separator)) {
        std::istringstream currIss(temp);

        T value;
        currIss >> value;

        out.emplace_back(value);
    }

    return out;
}

#endif //!SPLIT_H
