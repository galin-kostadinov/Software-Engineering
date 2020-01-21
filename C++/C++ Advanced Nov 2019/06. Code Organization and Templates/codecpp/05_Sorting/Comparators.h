#ifndef COMPARATORS_H
#define COMPARATORS_H

#include "Song.h"
#include "string"

template<typename T>
struct LessThan {
    bool operator()(const T &left, const T &right) const {
        return left < right;
    }
};

template<typename T, typename Comparator>
struct Reverse {
    bool operator()(const T &left, const T &right) {
        Comparator comp;

        return !comp(left, right);
    }
};

#endif //!COMPARATORS_H
