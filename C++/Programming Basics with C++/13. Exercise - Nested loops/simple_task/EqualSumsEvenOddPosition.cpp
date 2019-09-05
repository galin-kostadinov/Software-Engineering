#include <iostream>

using namespace std;

int main() {
    int firstNumber, secondNumber;
    cin >> firstNumber >> secondNumber;

    for (int num = firstNumber; num <= secondNumber; num++) {
        int lastNum = 0;
        int evenSum = 0;
        int oddSum = 0;
        int reduceNum = num;

        for (int i = 5; i >= 0; i--) {
            lastNum = reduceNum % 10;
            reduceNum = (reduceNum - lastNum) / 10;
            if (i % 2 == 0) {
                evenSum = evenSum + lastNum;
            } else {
                oddSum = oddSum + lastNum;
            }
        }

        if (evenSum == oddSum) {
            cout << num << " ";
        }
    }

    return 0;
}
