#include <iostream>
#include <string>

using namespace std;

int main() {

    int degrees;
    string dayTime;
    cin >> degrees >> dayTime;

    string outfit;
    string shoes;
    if (degrees >= 10 && degrees <= 18) {
        if (dayTime == "Morning") {
            outfit = "Sweatshirt";
            shoes = "Sneakers";
        } else if (dayTime == "Afternoon" || dayTime == "Evening") {
            outfit = "Shirt";
            shoes = "Moccasins";
        }
    } else if (degrees > 18 && degrees <= 24) {
        if (dayTime == "Morning" || dayTime == "Evening") {
            outfit = "Shirt";
            shoes = "Moccasins";
        } else if (dayTime == "Afternoon") {
            outfit = "T-Shirt";
            shoes = "Sandals";
        }
    } else if (degrees >= 25) {
        if (dayTime == "Morning") {
            outfit = "T-Shirt";
            shoes = "Sandals";
        } else if (dayTime == "Afternoon") {
            outfit = "Swim Suit";
            shoes = "Barefoot";
        } else if (dayTime == "Evening") {
            outfit = "Shirt";
            shoes = "Moccasins";
        }
    }

    cout << "It's " << degrees << " degrees, get your " << outfit << " and " << shoes <<"."<< endl;
    return 0;
}