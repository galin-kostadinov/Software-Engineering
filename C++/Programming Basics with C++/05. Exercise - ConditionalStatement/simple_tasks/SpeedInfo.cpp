#include <iostream>
#include <string>

using namespace std;

int main() {
    double speed;
    cin >> speed;

    string speedTest;
    if (speed <= 10) {
        speedTest = "slow";
    } else if (speed <= 50) {
        speedTest = "average";
    } else if (speed <= 150) {
        speedTest = "fast";
    } else if (speed <= 1000) {
        speedTest = "ultra fast";
    } else {
        speedTest = "extremely fast";
    }

    cout << speedTest << endl;

    return 0;
}