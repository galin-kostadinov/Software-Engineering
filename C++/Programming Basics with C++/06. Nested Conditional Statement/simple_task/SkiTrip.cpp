#include <iostream>
#include <string>

using namespace std;

int main() {

    string input;
    getline(cin, input);
    int days = stoi(input);

    string roomType;
    getline(cin, roomType);

    string rating;
    getline(cin, rating);

    days -= 1;

    double price = 0;

    if (roomType == "room for one person") {
        price = 18;
    } else if (roomType == "apartment") {
        price = 25;
        if (days < 10) {
            price *= 0.7;
        } else if (days >= 10 && days <= 15) {
            price *= 0.65;
        } else if (days > 15) {
            price *= 0.5;
        }
    } else if (roomType == "president apartment") {
        price = 35;
        if (days < 10) {
            price *= 0.9;
        } else if (days >= 10 && days <= 15) {
            price *= 0.85;
        } else if (days > 15) {
            price *= 0.80;
        }
    }

    if (rating == "positive") {
        price *= 1.25;
    } else {
        price *= 0.9;
    }

    cout.setf(ios::fixed);
    cout.precision(2);
    cout << price * days << endl;

    return 0;
}
