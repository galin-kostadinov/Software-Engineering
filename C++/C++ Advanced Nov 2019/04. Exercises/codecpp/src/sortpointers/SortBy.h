 #ifndef HOMEWORK_SORTBY_H
#define HOMEWORK_SORTBY_H

#include <algorithm>

bool (*globalComparator)(const Company &, const Company &) = nullptr;

bool myComparator(Company *left, Company *right) {
    return globalComparator(*left, *right);
}

void sortBy(Company **start, Company **end, bool (*comparator)(const Company &, const Company &)) {
    globalComparator = comparator;
    std::sort(start, end, myComparator);
}

#endif //HOMEWORK_SORTBY_H