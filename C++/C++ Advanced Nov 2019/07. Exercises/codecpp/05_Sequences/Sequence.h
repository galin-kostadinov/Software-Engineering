#ifndef SEQUENCE_H
#define SEQUENCE_H

#include <vector>
#include <iostream>

template<typename T>
class Iterator {
    static const int END_ITERATOR_INDEX = -1;
    std::vector<T> &elements;
    int next;

    Iterator(std::vector<T> &elements, int next) : elements(elements), next(next) {}

public:
    static Iterator begin(std::vector<T> &elements) {
        if (elements.size() == 0) {
            return end(elements);
        }

        return Iterator(elements, 0);
    }

    static Iterator end(std::vector<T> &elements) {
        return Iterator(elements, END_ITERATOR_INDEX);
    }

    bool operator!=(const Iterator &other) const {
        return this->elements != other.elements || this->next != other.next;
    }

    T &operator*() const {
        return this->elements.at(this->next);
    }

    Iterator &operator++() {
        ++this->next;

        if (this->next >= elements.size()) {
            this->next = END_ITERATOR_INDEX;
        }

        return *this;
    }
};

template<typename T, typename Generator>
class Sequence {
    std::vector<T> elements;
    Generator generator;
    typename std::vector<T>::iterator endIt;

public:
    Sequence() {}

    void generateNext(int numToGenerate) {
        for (int i = 0; i < numToGenerate; ++i) {
            int num = this->generator();
            elements.emplace_back(num);
        }
    }

    Iterator<T> begin() {
        return Iterator<T>::begin(this->elements);
    }

    Iterator<T> end() {
        return Iterator<T>::end(this->elements);
    }
};

#endif //!SEQUENCE_H
