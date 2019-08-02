#include <iostream>

using namespace std;

int main() {
    int age;
    double washingMachinePrice;
    int toyPrice;
    cin >> age >> washingMachinePrice >> toyPrice;
    double saveMoney = 0.0;
    int counterOddDays = 0;
    for (int i = 1; i <= age; i++) {
        if (i % 2 == 0) {
            ++counterOddDays;
            saveMoney = saveMoney + 10 * (counterOddDays) - 1;
        } else {
            saveMoney = saveMoney + toyPrice;
        }
    }
    cout.setf(ios::fixed);
    cout.precision(2);
    if (saveMoney >= washingMachinePrice) {
        cout << "Yes! " << saveMoney - washingMachinePrice << endl;
    } else {
        cout << "No! " << washingMachinePrice - saveMoney << endl;
    }

    return 0;
}
