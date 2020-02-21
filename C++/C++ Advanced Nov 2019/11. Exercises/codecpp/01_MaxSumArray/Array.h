#ifndef ARRAY_H
#define ARRAY_H

#include <cstdlib>

template<typename T>
class Array {
    size_t arrSize;
    T *array;
public:
    Array(size_t arrSize) : arrSize(arrSize), array(new T[arrSize]) {}

    Array(const Array<T> &other) {
        this->arrSize = other.arrSize;
        this->array = new T[this->arrSize];

        for (int i = 0; i < this->arrSize; ++i) {
            this->array[i] = other.array[i];
        }
    }

    Array &operator=(const Array &other) {
        if (this != &other) {
            delete[] this->array;
            this->arrSize = other.arrSize;
            this->array = new T[this->arrSize];

            for (int i = 0; i < this->arrSize; ++i) {
                this->array[i] = other.array[i];
            }
        }

        return *this;
    }

    size_t getSize() const {
        return this->arrSize;
    }

    T *begin() const {
        return (this->array);
    }

    T *end() const {
        return (this->array + this->arrSize);
    }

    T &operator[](size_t index) const {
        return this->array[index];
    }

    ~Array() {
        delete[]this->array;
        this->array = nullptr;
    }
};

#endif //!ARRAY_H
