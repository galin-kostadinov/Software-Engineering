#include <iostream>

#include "BigInt.h"

int main() {
    std::string lower, upper;
    std::cin >> lower >> upper;

    BigInt lowerBound(lower);
    BigInt upperBound(upper);

    BigInt number = lowerBound;

    while (true) {
        int sum = 0;
        std::string numberAsString = number.getDigits();
        int size = (size_t) numberAsString.length();

        for (int i = 0; i < size; ++i) {
            sum += numberAsString[i] - '0';
        }

        if (sum % 9 == 0 && (numberAsString[size - 1] == '5' || numberAsString[size - 1] == '0')) {
            break;
        } else {
            number += 1;
        }
    }

    while (number < upperBound) {
        std::cout << number << std::endl;
        number += BigInt(45);
    }

    return 0;
}