#ifndef CODECPP_SUMOFVECTORS_H
#define CODECPP_SUMOFVECTORS_H

#include <vector>
#include <string>

std::vector<std::string> operator+(std::vector<std::string> &a, std::vector<std::string> &b) {
    int size = (size_t) a.size();

    std::vector<std::string> result(size);

    for (int i = 0; i < size; ++i) {
        result[i] = a[i] + " " + b[i];
    }

    return result;
}

#endif //!CODECPP_SUMOFVECTORS_H
