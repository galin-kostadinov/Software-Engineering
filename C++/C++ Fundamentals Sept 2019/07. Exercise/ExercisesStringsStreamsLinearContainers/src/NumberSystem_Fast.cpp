#include <iostream>
#include <string>
#include <vector>

int getIntFromString(const std::vector<int> &digits, const std::string &number) {
    int result = 0;

    int power = 10;

    for (const auto digit : number) {
        result *= power;
        result += digits[digit];
    }

    return result;
}

std::string getStringFromInt(std::string &digitsRepresentation, const int number) {
    std::string result;

    std::string numberAsString = std::to_string(number);

    for (const auto digit : numberAsString) {
        int index = digit - '0';

        char symbolInCurrantSystem = digitsRepresentation[index];
        result.push_back(symbolInCurrantSystem);
    }

    return result;
}

void readInput(std::vector<int> &outDigit, std::string &digitsRepresentation,
               std::string &firstNumber, std::string &secondNumber) {

    std::string inputDigitStr;
    std::cin >> inputDigitStr >> firstNumber >> secondNumber;

    digitsRepresentation = inputDigitStr;

    int index = 0;
    for (const auto &digit : inputDigitStr) {
        outDigit[digit] = index++;
    }

}

int main() {
    std::vector<int> digits(255);
    std::string digitsRepresentation;
    std::string firstNumberAsString;
    std::string secondNumberAsString;

    readInput(digits, digitsRepresentation, firstNumberAsString, secondNumberAsString);

    int firstNumber = getIntFromString(digits, firstNumberAsString);
    int secondNumber = getIntFromString(digits, secondNumberAsString);

    const int sum = firstNumber + secondNumber;

    std::cout << getStringFromInt(digitsRepresentation, sum) << std::endl;

    return 0;
}