#include <iostream>

int main() {
    int number = 0;
    std::cin >> number;

    int evenSum = 0;
    int oddSum = 0;

    while (number != 0) {
        int currentDigit = number % 10;
        number /= 10;

        if (currentDigit & 1) {
            oddSum += currentDigit;
        } else {
            evenSum += currentDigit;
        }
    }

    std::cout << evenSum * oddSum << std::endl;

    return 0;
}
