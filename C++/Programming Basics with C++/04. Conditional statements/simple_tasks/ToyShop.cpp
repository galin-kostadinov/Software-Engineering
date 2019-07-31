#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double neededMoney;
    cin >> neededMoney;
    int puzzlesCount, dollsCount, teddyBearsCount, minionsCount, truckCount;
    cin >> puzzlesCount >> dollsCount >> teddyBearsCount >> minionsCount >> truckCount;

    double result = 2.6 * puzzlesCount + 3 * dollsCount + 4.1 * teddyBearsCount + 8.2 * minionsCount + 2 * truckCount;
    int toysCount = puzzlesCount + dollsCount + teddyBearsCount + minionsCount + truckCount;

    if (toysCount >= 50) {
        result *= 0.75;
    }
    result *= 0.9;

    double leftMoney = result - neededMoney;

    cout.setf(iostream::fixed);
    cout.precision(2);

    if (leftMoney >= 0) {
        cout << "Yes! " << leftMoney << " lv left." << endl;
    } else {
        cout << "Not enough money! " << abs(leftMoney) << " lv needed." << endl;
    }

    return 0;
}