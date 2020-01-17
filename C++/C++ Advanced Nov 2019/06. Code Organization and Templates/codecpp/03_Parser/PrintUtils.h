#ifndef PRINTUTILS_H
#define PRINTUTILS_H

template<typename T>
void printVector(std::vector<T> data) {
    for (const auto &d : data) {
        std::cout << d << ' ';
    }

    std::cout << std::endl;
}

#endif //!PRINTUTILS_H