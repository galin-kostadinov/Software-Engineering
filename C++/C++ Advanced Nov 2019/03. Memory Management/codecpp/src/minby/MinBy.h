#ifndef CODECPP_MINBY_H
#define CODECPP_MINBY_H

#include <algorithm>

std::string minBy(std::vector<std::string> &values,
                  bool(*comparator)(const std::string &, const std::string &)) {
    std::string result;

    std::sort(values.begin(), values.end(), comparator);

    result = values[0];
    return result;
}

#endif //CODECPP_MINBY_H
