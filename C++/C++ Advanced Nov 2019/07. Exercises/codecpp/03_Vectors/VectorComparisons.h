#ifndef VECTORCOMPARISONS_H
#define VECTORCOMPARISONS_H

#include "Vector.h"

struct VectorLengthComparer {
    bool operator()(const Vector &left, const Vector &right) const {
        return left.getLengthSq() < right.getLengthSq();
    }
};

template<typename T, typename Comp>
class ReverseComparer {
    Comp comparer;
public:
    bool operator()(const T &left, const T &right) const {
        return !comparer(left, right);
    }
};

#endif //!VECTORCOMPARISONS_H
