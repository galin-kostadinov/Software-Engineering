#ifndef PRINTUTILS_H
#define PRINTUTILS_H

#include <set>

template<typename Set>
void printContainer(const typename Set::iterator &begin, const typename Set::iterator &end) {
    typename Set::iterator it = begin;

    while (it != end) {
        std::cout << (*it) << ' ';
        it++;
    }

    std::cout << std::endl;
}

#endif //!PRINTUTILS_H