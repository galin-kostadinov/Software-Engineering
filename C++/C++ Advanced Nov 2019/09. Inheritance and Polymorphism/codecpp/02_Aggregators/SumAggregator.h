#ifndef SUMAGGREGATOR_H
#define SUMAGGREGATOR_H

#include "Aggregator.h"

class SumAggregator : public StreamAggregator {

public:
    SumAggregator(std::istream &stream) : StreamAggregator(stream) {
        StreamAggregator::aggregationResult = 0;
    }

    void aggregate(int next) override {
        StreamAggregator::aggregationResult += next;
    }
};

#endif //!SUMAGGREGATOR_H
