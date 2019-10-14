#include<iostream>
#include<vector>

void readDigits(std::vector<char> &splittedNumber) {
    char currentChar;

    std::cin.sync_with_stdio(false);
    for (int i = 0; i < 5; ++i) {
        std::cin >> currentChar;
        splittedNumber[i] = currentChar;

        if (currentChar == '.') {
            break;
        }
    }
}

int main() {
    std::cin.sync_with_stdio(false);

    std::vector<char> splittedNumber(5);

    readDigits(splittedNumber);

    char result[5] = {};

    while (true) {
        if (splittedNumber[0] == '.') {
            break;
        }

        for (int i = 0; i < 5; ++i) {
            result[i] = result[i] ^ splittedNumber[i];
        }

        readDigits(splittedNumber);
    }

    std::cout.sync_with_stdio(false);

    for (int i = 0; i < 5; ++i) {
        std::cout << result[i];
    }

    std::cout << std::endl;

    return 0;
}