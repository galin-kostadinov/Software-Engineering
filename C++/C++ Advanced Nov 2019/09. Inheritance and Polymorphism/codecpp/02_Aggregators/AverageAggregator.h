#ifndef AVERAGEAGGREGATOR_H
#define AVERAGEAGGREGATOR_H

#include "Aggregator.h"

class AverageAggregator : public StreamAggregator {
private:
    int sum;

public:
    AverageAggregator(std::istream &stream) : StreamAggregator(stream), sum(0) {}

    void aggregate(int next) override {
        StreamAggregator::aggregate(next);
        this->sum += next;
        StreamAggregator::aggregationResult = sum / StreamAggregator::getNumAggregated();
    }
};

#endif //!AVERAGEAGGREGATOR_H
