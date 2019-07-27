#include <iostream>
#include <string>

using namespace std;

int main() {
    string town;
    double income;
    cin >> town >> income;

    double commission = -1;

    if (town == "Sofia") {
        if (income >= 0 && income <= 500) {
            commission = 0.05;
        } else if (income > 500 && income <= 1000) {
            commission = 0.07;
        } else if (income > 1000 && income <= 10000) {
            commission = 0.08;
        } else if (income > 10000) {
            commission = 0.12;
        }

    } else if (town == "Varna") {
        if (income >= 0 && income <= 500) {
            commission = 0.045;
        } else if (income > 500 && income <= 1000) {
            commission = 0.075;
        } else if (income > 1000 && income <= 10000) {
            commission = 0.10;
        } else if (income > 10000) {
            commission = 0.13;
        }
    } else if (town == "Plovdiv") {
        if (income >= 0 && income <= 500) {
            commission = 0.055;
        } else if (income > 500 && income <= 1000) {
            commission = 0.08;
        } else if (income > 1000 && income <= 10000) {
            commission = 0.12;
        } else if (income > 10000) {
            commission = 0.145;
        }
    }

    if (commission >= 0) {
        cout.setf(ios::fixed);
        cout.precision(2);
        cout << commission * income << endl;
    } else {
        cout << "error" << endl;
    }

    return 0;
}
