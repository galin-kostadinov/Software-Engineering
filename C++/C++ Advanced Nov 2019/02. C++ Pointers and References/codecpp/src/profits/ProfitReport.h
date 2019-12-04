#ifndef CODECPP_PROFITREPORT_H
#define CODECPP_PROFITREPORT_H

#include "Company.h"
#include "ProfitCalculator.h"
#include <map>
#include <sstream>

std::string getProfitReport(Company *fromInclusive, Company *toInclusive,
                            std::map<int, ProfitCalculator> &profitCalculatorsByCompany) {
    std::ostringstream oss;
    int id = 0;
    int result = 0;

    for (const Company *company = fromInclusive; company <= toInclusive; company++) {
        id = company->getId();
        result = profitCalculatorsByCompany.find(id)->second.calculateProfit(*company);
        oss << company->getName() << " = " << result;

        if (company != toInclusive) {
            oss << std::endl;
        }
    }

    return oss.str();
}


#endif //CODECPP_PROFITREPORT_H
