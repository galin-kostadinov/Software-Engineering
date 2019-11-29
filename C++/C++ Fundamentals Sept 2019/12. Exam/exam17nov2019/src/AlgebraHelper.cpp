#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
#include <utility>
#include <vector>

bool sortByFirst(const std::pair<int, std::string> &a,
                 const std::pair<int, std::string> &b) {
    return (a.first > b.first);
}

int calculate(std::string &line) {
    std::istringstream iss(line);
    int firstNumber;
    int secondNumber;
    char operation;
    iss >> firstNumber >> operation >> secondNumber;

    int result = 0;

    switch (operation) {
        case '+':
            result = firstNumber + secondNumber;
            break;
        case '-':
            result = firstNumber - secondNumber;
            break;
        case '*':
            result = firstNumber * secondNumber;
            break;
        case '/':
            result = firstNumber / secondNumber;
            break;
        case '%':
            result = firstNumber % secondNumber;
            break;
        default:
            break;
    }

    return result;
}

void print(std::vector<std::pair<int, std::string>> &data) {
    for (auto &kvp:data) {
        std::cout << kvp.second << std::endl;
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    std::vector<std::pair<int, std::string>> data;

    int operationsCount;
    std::cin >> operationsCount;
    std::cin.ignore();

    std::string line;
    while (operationsCount-- > 0) {
        getline(std::cin, line);

        int result = calculate(line);
        data.emplace_back(make_pair(result, line));
    }

    sort(data.begin(), data.end(), sortByFirst);

    print(data);

    return 0;
}