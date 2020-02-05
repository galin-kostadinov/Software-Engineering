#ifndef TYPEDSTREAM_H
#define TYPEDSTREAM_H

#include <vector>
#include <string>
#include <istream>
#include <sstream>

template<typename T>
class TypedStream {
protected:
    std::istringstream stream;

public:
    explicit TypedStream(const std::string &input) : stream(input) {}

    virtual TypedStream<T> &operator>>(T &s) {
        return *this;
    }

    std::vector<T> readToEnd() {
        std::vector<T> v;

        T element;

        this->operator>>(element);
        while (this->stream) {
            v.emplace_back(element);
            this->operator>>(element);
        }

        return v;
    }

    virtual ~TypedStream() {}
};

#endif //!TYPEDSTREAM_H
