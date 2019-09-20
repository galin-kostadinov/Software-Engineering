#include <iostream>
#include<vector>
#include<cmath>

using namespace std;

void readDigits(vector<int> &splittedNumber) {
    char currentChar;
    cin >> currentChar;

    while (currentChar != '.') {
        int currentDigit = currentChar - '0';

        if (currentDigit >= 0 && currentDigit <= 9) {
            splittedNumber.push_back(currentDigit);
        }

        cin >> currentChar;
    }
}

int agregateNumber(const vector<int> &splittedNumber) {
    int size = (int) splittedNumber.size();

    int number = 0;
    int power = 1;

    for (int i = size - 1; i >= 0; --i) {
        number += splittedNumber[i] * power;
        power *= 10;
    }

    return number;
}

int main() {
    vector<int> splittedNumber;

    readDigits(splittedNumber);

    int number = agregateNumber(splittedNumber);

    cout << sqrt(number) << endl;

    return 0;
}