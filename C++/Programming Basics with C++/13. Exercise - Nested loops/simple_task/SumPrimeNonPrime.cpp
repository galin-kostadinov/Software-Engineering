#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    int primeNumbersSum = 0;
    int notPrimeNumbersSum = 0;
    string input;
    getline(cin, input);

    while (input != "STOP" && input != "stop") {
        int num = stoi(input);

        if (num < 0) {
            cout << "Number is negative." << endl;
        } else if (num == 0 || num == 1) {
            notPrimeNumbersSum += num;
        } else {
            bool primeNum = true;

            for (int n = 2; n < num; n++) {
                if (num % n == 0) {
                    notPrimeNumbersSum += num;
                    primeNum = false;
                    break;
                }
            }

            if (primeNum) {
                primeNumbersSum += num;
            }
        }

        getline(cin, input);
    }

    cout << "Sum of all prime numbers is: " << primeNumbersSum << endl;
    cout << "Sum of all non prime numbers is: " << notPrimeNumbersSum << endl;

    return 0;
}
