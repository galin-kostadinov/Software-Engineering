#ifndef MINAGGREGATOR_H
#define MINAGGREGATOR_H

#include "Aggregator.h"

class MinAggregator : public StreamAggregator {

public:
    MinAggregator(std::istream &stream) : StreamAggregator(stream) {
        StreamAggregator::aggregationResult = INT32_MAX;
    }

    void aggregate(int next) override {
        if (next < StreamAggregator::getAggregationResult()) {
            StreamAggregator::aggregationResult = next;
        }
    }
};

#endif //!MINAGGREGATOR_H
