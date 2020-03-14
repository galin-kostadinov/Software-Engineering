#ifndef STATISTICS_H
#define STATISTICS_H

#include <ostream>
#include <vector>
#include "Structs.h"

class Statistics {
private:
    std::vector<PersonInfo> minors;
    std::vector<PersonInfo> adults;
    std::vector<PersonInfo> elders;

public:
    Statistics() = default;

    void printStatistics();

    Statistics &operator<<(const PersonInfo &personInfo);
};

#endif //STATISTICS_H
