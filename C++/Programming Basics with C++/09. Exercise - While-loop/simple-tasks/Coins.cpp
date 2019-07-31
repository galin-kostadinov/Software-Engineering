#include<iostream>
#include <cmath>

using namespace std;

int main() {
    double resetLv;
    cin >> resetLv;

    int resetCoins = (int) round(resetLv * 100);
    int numCoins = 0;
    while (resetCoins != 0) {
        if (resetCoins >= 200) {
            numCoins += floor(resetCoins / 200);
            resetCoins = resetCoins % 200;
        }
        if (resetCoins >= 100) {
            numCoins += floor(resetCoins / 100);
            resetCoins = resetCoins % 100;
        }
        if (resetCoins >= 50) {
            numCoins += floor(resetCoins / 50);
            resetCoins = resetCoins % 50;
        }
        if (resetCoins >= 20) {
            numCoins += floor(resetCoins / 20);
            resetCoins = resetCoins % 20;
        }
        if (resetCoins >= 10) {
            numCoins += floor(resetCoins / 10);
            resetCoins = resetCoins % 10;
        }
        if (resetCoins >= 5) {
            numCoins += floor(resetCoins / 5);
            resetCoins = resetCoins % 5;
        }
        if (resetCoins >= 2) {
            numCoins += floor(resetCoins / 2);
            resetCoins = resetCoins % 2;
        }
        if (resetCoins >= 1) {
            numCoins += floor(resetCoins / 1);
            resetCoins = resetCoins % 1;
        }
    }

    cout << numCoins << endl;

    return 0;
}