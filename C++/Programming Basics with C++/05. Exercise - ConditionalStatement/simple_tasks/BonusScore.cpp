#include <iostream>

using namespace std;

int main() {
    int num;
    cin >> num;

    double bonus = 0;
    if (num <= 100) {
        bonus = 5;
    } else if (num <= 1000) {
        bonus = num * 0.2;
    } else if (num > 1000) {
        bonus = num * 0.1;
    }

    if (num % 2 == 0) {
        bonus += 1;
    } else if (num % 5 == 0) {
        bonus += 2;
    }
    cout << bonus << endl << bonus + num << endl;

    return 0;
}