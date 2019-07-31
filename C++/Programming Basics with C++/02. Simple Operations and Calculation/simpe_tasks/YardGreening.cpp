#include <iostream>

using namespace std;

int main() {
    double area;
    cin >> area;
    double finalPrice = 7.61 * area * 0.82;
    double discount = 7.61 * area * 0.18;

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << "The final price is: " << finalPrice << " lv." << endl;
    cout << "The discount is: " << discount << " lv." << endl;

    return 0;
}