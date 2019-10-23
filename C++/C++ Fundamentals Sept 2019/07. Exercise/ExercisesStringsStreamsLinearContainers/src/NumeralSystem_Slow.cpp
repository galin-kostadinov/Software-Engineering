#include <iostream>
#include <string>

int createNumber(const std::string &numberSystemSymbols, const std::string &numberAsString) {
    std::string numberAsStringDigit;

    for (size_t j = 0; j < numberAsString.size(); ++j) {
        for (int i = 0; i <= 9; ++i) {
            if (numberSystemSymbols[i] == numberAsString[j]) {
                numberAsStringDigit += std::to_string(i);
            }
        }
    }

    int number = std::stoi(numberAsStringDigit);
    return number;
}

std::string createString(const std::string &numberSystemSymbols, int number) {
    std::string numberAsStringDigit = std::to_string(number);

    std::string numberAsString;

    for (size_t j = 0; j < numberAsStringDigit.size(); ++j) {
        for (int i = 0; i <= 9; ++i) {
            if (i == (numberAsStringDigit[j]-'0')) {
                numberAsString += numberSystemSymbols[i];
            }
        }
    }

    return numberAsString;
}

int main() {
    std::string numberSystemSymbols;
    std::string firstNumberAsText;
    std::string secondNumberAsText;

    std::cin >> numberSystemSymbols >> firstNumberAsText >> secondNumberAsText;

    int firstNumber = createNumber(numberSystemSymbols, firstNumberAsText);
    int secondNumber = createNumber(numberSystemSymbols, secondNumberAsText);

    int result = firstNumber + secondNumber;

    std::string resultAsString;
    resultAsString = createString(numberSystemSymbols, result);
    std::cout << resultAsString << std::endl;

    return 0;
}