#ifndef CODECPP_OPERATORS_H
#define CODECPP_OPERATORS_H

#include <vector>
#include<sstream>
#include<string>

std::vector<std::string> &operator<<(std::vector<std::string> &a, std::string &b) {
    a.emplace_back(b);

    return a;
}

std::ostream &operator<<(std::ostream &oss, std::vector<std::string> &a) {
    for (const auto &item : a) {
        oss << item << std::endl;
    }

    return oss;
}

std::string &operator+(std::string &a, int b) {
    a.append(std::to_string(b));

    return a;
}

#endif //!CODECPP_OPERATORS_H
