#ifndef JOIN_H
#define JOIN_H

#include <string>
#include <sstream>
#include <vector>

template<typename T>
std::string join(std::vector<T> &words, std::string &joinStr) {
    std::ostringstream oss;

    bool putJoinStr = false;

    for (const auto &item : words) {
        if (putJoinStr) {
            oss << joinStr;
        }

        oss << item;
        putJoinStr = true;
    }

    return oss.str();
}

#endif //!JOIN_H
