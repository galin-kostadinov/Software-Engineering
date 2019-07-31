#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    int budget;
    string season;
    int numberFishermen;

    cin >> budget >> season >> numberFishermen;

    transform(season.begin(),
              season.end(),
              season.begin(),
              ::tolower);

    double rent = 0;

    if (season == "summer" || season == "autumn") {
        rent = 4200;
    } else if (season == "spring") {
        rent = 3000;
    } else if (season == "winter") {
        rent = 2600;
    }

    if (numberFishermen >= 1 && numberFishermen <= 6) {
        rent = rent - rent * 0.1;
    } else if (numberFishermen >= 7 && numberFishermen <= 11) {
        rent = rent - rent * 0.15;
    } else if (numberFishermen >= 12) {
        rent = rent - rent * 0.25;
    }
    if (season != "autumn" && numberFishermen % 2 == 0) {
        rent = rent - rent * 0.05;
    }

    double leftMoney = budget - rent;

    cout.setf(ios::fixed);
    cout.precision(2);

    if (leftMoney >= 0) {
        cout << "Yes! You have " << leftMoney << " leva left." << endl;
    } else if (leftMoney < 0) {

        cout << "Not enough money! You need " << abs(leftMoney) << " leva." << endl;
    }

    return 0;
}