#include <iostream>

using namespace std;

int main() {
    double budget;
    int statistics;
    double clothesPrice;
    cin >> budget >> statistics >> clothesPrice;

    if (statistics > 150) {
        clothesPrice *= 0.9;
    }

    double totalPrice = clothesPrice * statistics + budget * 0.1;

    cout.setf(iostream::fixed);
    cout.precision(2);

    if (totalPrice <= budget) {
        cout << "Action!" << endl;
        cout << "Wingard starts filming with " << budget - totalPrice << " leva left." << endl;
    } else {
        cout << "Not enough money!" << endl;
        cout << "Wingard needs " << totalPrice - budget << " leva more." << endl;
    }

    return 0;
}