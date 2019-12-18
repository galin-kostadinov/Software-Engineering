#ifndef CODECPP_CAR_H
#define CODECPP_CAR_H

#include <string>

using namespace std;

class Car {
    string sBrand;
    string sModel;
    int nYear;

public:
    Car(string &sBrand, string &sModel, int nYear) :
            sBrand(sBrand), sModel(sModel), nYear(nYear) {
    }

    string GetBrand() const {
        return this->sBrand;
    }

    string GetModel() const {
        return this->sModel;
    }

    int GetYear() const {
        return this->nYear;
    }
};

#endif //!CODECPP_CAR_H
