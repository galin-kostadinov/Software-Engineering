#include <iostream>
#include <string>
#include <cctype>
#include <sstream>

int main() {
    int length;
    std::string first;
    std::string second;

    std::cin >> length >> first >> second;

    char symbolFirst;
    char symbolSecond;

    int countDiff = 0;
    int sumDigits = 0;
    std::ostringstream oss;
    for (int i = 0; i < length; ++i) {
        symbolFirst = first[i];
        symbolSecond = second[i];

        if (isdigit(symbolFirst)) {
            sumDigits += symbolFirst - '0';
        }
        if (isdigit(symbolSecond)) {
            sumDigits += symbolSecond - '0';
        }

        if (symbolFirst == symbolSecond) {
            oss << (char) symbolFirst;
        } else if (toupper(symbolFirst) == toupper(symbolSecond)) {
            oss << (char) toupper(symbolFirst);
        } else {
            oss << '#';
            countDiff++;
        }
    }

    std::cout << oss.str() << std::endl;
    std::cout << countDiff << std::endl;
    std::cout << length - countDiff << std::endl;
    std::cout << sumDigits << std::endl;

    return 0;
}