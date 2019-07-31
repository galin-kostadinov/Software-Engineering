#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    string typeFlowers;
    int flowersCount;
    int budget;
    cin >> typeFlowers >> flowersCount >> budget;

    double totalPrice = 0;

    if (typeFlowers == "Roses") {
        totalPrice = flowersCount * 5.0;
        if (flowersCount > 80) {
            totalPrice *= 0.9;
        }
    } else if (typeFlowers == "Dahlias") {
        totalPrice = flowersCount * 3.8;
        if (flowersCount > 90) {
            totalPrice *= 0.85;
        }
    } else if (typeFlowers == "Tulips") {
        totalPrice = flowersCount * 2.8;
        if (flowersCount > 80) {
            totalPrice *= 0.85;
        }
    } else if (typeFlowers == "Narcissus") {
        totalPrice = flowersCount * 3.0;
        if (flowersCount < 120) {
            totalPrice *= 1.15;
        }
    } else if (typeFlowers == "Gladiolus") {
        totalPrice = flowersCount * 2.5;
        if (flowersCount < 80) {
            totalPrice *= 1.20;
        }
    }

    double leftMoney = budget - totalPrice;

    cout.setf(ios::fixed);
    cout.precision(2);

    if (leftMoney >= 0) {
        cout << "Hey, you have a great garden with " << flowersCount << " " << typeFlowers << " and " << leftMoney
             << " leva left." << endl;
    } else {
        cout << "Not enough money, you need " << abs(leftMoney) << " leva more." << endl;
    }

    return 0;
}