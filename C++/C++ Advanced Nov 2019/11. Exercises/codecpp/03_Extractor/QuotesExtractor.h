#ifndef QUOTES_EXTRACTOR_H
#define QUOTES_EXTRACTOR_H

#include "BufferedExtractor.h"

class QuotesExtractor : public BufferedExtractor {
private:
    bool isQuotesStart;
protected:
    bool shouldBuffer(char symbol) override {
        if (symbol == '\"' && !isQuotesStart) {
            isQuotesStart = true;
            return false;
        } else if (isQuotesStart && symbol != '\"') {
            return true;
        } else {
            isQuotesStart = false;
            return false;
        }
    }

public:
    QuotesExtractor(std::istream &stream) : BufferedExtractor(stream), isQuotesStart(false) {}

};

#endif //!QUOTES_EXTRACTOR_H
