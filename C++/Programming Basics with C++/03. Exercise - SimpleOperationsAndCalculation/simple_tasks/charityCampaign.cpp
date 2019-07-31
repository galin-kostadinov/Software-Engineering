#include <iostream>

using namespace std;

int main() {
    int days, cookers, cakes, wafer, pancakes;
    cin >> days >> cookers >> cakes >> wafer >> pancakes;

    double allMoney = (45 * cakes + 5.8 * wafer + 3.2 * pancakes) * days * cookers;
    double result = allMoney - allMoney / 8;

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << result << endl;

    return 0;
}