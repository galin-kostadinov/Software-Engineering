#include<iostream>
#include<vector>
#include<cctype>
#include<iomanip>

void readDigits(std::vector<char> &splittedNumber) {
    char currentChar;
    int counter = 0;

    std::cin.sync_with_stdio(false);

    while (counter < 5) {
        std::cin >> currentChar;
        splittedNumber.push_back(currentChar);
        counter++;

        if (currentChar == '.') {
            break;
        }
    }
}

int main() {
    std::cin.sync_with_stdio(false);

    std::vector<char> splittedNumber;

    readDigits(splittedNumber);

    int result = 0;

    while (true) {
        if (splittedNumber[0] == '.') {
            break;
        }

        int currentNumber = 0;
        int power = 1;

        for (int i = 4; i >= 0; --i) {
            int representativeDigit = 0;
            if (isdigit(splittedNumber[i])) {
                representativeDigit = splittedNumber[i] - '0';
            } else {
                representativeDigit = splittedNumber[i] - 'a' + 10;
            }

            currentNumber += representativeDigit * power;
            power *= 16;
        }

        result = result ^ currentNumber;

        splittedNumber.clear();
        readDigits(splittedNumber);
    }

    std::cout.sync_with_stdio(false);

    std::cout << std::setfill('0') << std::setw(5) << std::hex << result << std::endl;

    return 0;
}
// int number = 0xbca98;
//uint32_t i = 4294967295;
//result ^= input<<(--i%5)*4; // including char by char from std::cin>>