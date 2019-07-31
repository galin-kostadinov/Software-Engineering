#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {

    string typeOfYear;
    int holidays;
    int weekendTripCount;
    cin >> typeOfYear >> holidays >> weekendTripCount;
    transform(typeOfYear.begin(),
              typeOfYear.end(),
              typeOfYear.begin(),
              ::tolower);

    double numberSportingDays = 0;
    if (typeOfYear == "normal") {
        numberSportingDays = weekendTripCount + (48 - weekendTripCount) * 3 / 4.0 + holidays * 2 / 3.0;
        cout << floor(numberSportingDays) << endl;
    } else if (typeOfYear == "leap") {
        numberSportingDays = (weekendTripCount + (48 - weekendTripCount) * 3 / 4.0 + holidays * 2 / 3.0) * 1.15;
        cout << floor(numberSportingDays)<<endl;
    }
    return 0;
}