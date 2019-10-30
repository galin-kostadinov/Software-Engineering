#include <iostream>
#include <string>
#include <deque>

int main() {
    std::string input;
    std::cin >> input;

    std::deque<int> numbers;

    while ("end" != input) {
        if (isdigit(input[input.size() - 1])) {
            numbers.push_back(stoi(input));
        } else if (input == "sum") {
            int firstNum = numbers.back();
            numbers.pop_back();

            int secondNum = numbers.back();
            numbers.pop_back();

            int result = firstNum + secondNum;
            numbers.push_back(result);
        } else if (input == "subtract") {
            int firstNum = numbers.back();
            numbers.pop_back();

            int secondNum = numbers.back();
            numbers.pop_back();

            int result = firstNum - secondNum;
            numbers.push_back(result);
        } else if (input == "concat") {
            int firstNum = numbers.back();
            numbers.pop_back();

            int secondNum = numbers.back();
            numbers.pop_back();

            std::string resultAsString = std::to_string(secondNum) + std::to_string(firstNum);

            int result = stoi(resultAsString);
            numbers.push_back(result);
        } else if (input == "discard") {
            numbers.pop_back();
        }

        std::cin >> input;
    }

    while (!numbers.empty()) {
        std::cout << numbers.front() << std::endl;
        numbers.pop_front();
    }

    return 0;
}