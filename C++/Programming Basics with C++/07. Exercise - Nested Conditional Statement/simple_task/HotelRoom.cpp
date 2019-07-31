#include <iostream>
#include <string>

using namespace std;

int main() {
    string month;
    int nights;
    cin >> month >> nights;

    double apartmentPrice = 0;
    double studioPrice = 0;

    if (month == "May" || month == "October") {
        studioPrice = 50 * nights;
        apartmentPrice = 65 * nights;
        if (nights > 7 && nights <= 14) {
            studioPrice *= 0.95;
        } else if (nights > 14) {
            studioPrice *= 0.7;
        }
    } else if (month == "June" || month == "September") {
        studioPrice = 75.2 * nights;
        apartmentPrice = 68.70 * nights;
        if (nights > 14) {
            studioPrice *= 0.8;
        }
    } else if (month == "July" || month == "August") {
        studioPrice = 76 * nights;
        apartmentPrice = 77 * nights;
    }

    if (nights > 14) {
        apartmentPrice *= 0.9;
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << "Apartment: " << apartmentPrice << " lv." << endl;
    cout << "Studio: " << studioPrice << " lv." << endl;

    return 0;
}