#ifndef NUMBERS_EXTRACTOR_H
#define NUMBERS_EXTRACTOR_H

#include "BufferedExtractor.h"

class NumbersExtractor : public BufferedExtractor {
protected:
    bool shouldBuffer(char symbol) override {
        return isdigit(symbol);
    }

public:
    explicit NumbersExtractor(std::istream &stream) : BufferedExtractor(stream) {}
};

#endif //!NUMBERS_EXTRACTOR_H
