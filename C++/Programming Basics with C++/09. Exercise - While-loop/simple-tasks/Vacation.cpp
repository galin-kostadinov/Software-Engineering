#include<iostream>
#include <string>

using namespace std;

int main() {
    double vacationPrice, cash;
    cin >> vacationPrice >> cash;

    int spendMoneyCounter = 0;
    int daysCounter = 0;

    while (vacationPrice > cash && spendMoneyCounter < 5) {
        string command;
        cin >> command;
        double money;
        cin >> money;
        daysCounter++;
        if (command == "save") {
            cash += money;
            spendMoneyCounter = 0;
        } else if (command == "spend") {
            cash -= money;
            if (cash < 0) {
                cash = 0;
            }
            spendMoneyCounter++;
            if (spendMoneyCounter >= 5) {
                break;
            }
        }
    }
    if (spendMoneyCounter >= 5) {
        cout << "You can't save the money." << endl;
        cout << daysCounter << endl;
    }
    if (cash >= vacationPrice) {
        cout << "You saved the money for " << daysCounter << " days.";
    }

    return 0;
}