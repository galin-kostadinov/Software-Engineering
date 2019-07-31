#include <iostream>
#include <string>

using namespace std;

int main() {
    double budget;
    string season;
    cin >> budget >> season;

    string destination;
    string place;
    double totalPrice;

    if (budget <= 100) {
        destination = "Bulgaria";
        if (season == "summer") {
            place = "Camp";
            totalPrice = budget * 0.3;
        } else {
            place = "Hotel";
            totalPrice = budget * 0.7;
        }
    } else if (budget <= 1000) {
        destination = "Balkans";
        if (season == "summer") {
            place = "Camp";
            totalPrice = budget * 0.4;
        } else {
            place = "Hotel";
            totalPrice = budget * 0.8;
        }
    } else {
        destination = "Europe";
        place = "Hotel";
        totalPrice = budget * 0.9;
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << "Somewhere in " << destination << endl;
    cout << place << " - " << totalPrice << endl;

    return 0;
}