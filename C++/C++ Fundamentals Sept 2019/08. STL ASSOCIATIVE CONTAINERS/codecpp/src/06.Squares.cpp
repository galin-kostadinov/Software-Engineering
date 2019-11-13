#include <iostream>
#include <sstream>
#include <set>
#include <cmath>

void print(std::set<int, std::greater_equal<int>> &numbers) {
    for (const int number : numbers) {
        std::cout << number << " ";
    }
}

bool isSquareNumber(const int number) {
    int square = (int) sqrt(number);

    return square * square == number;
}

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::set<int, std::greater_equal<int>> numbers;

    std::istringstream stream(line);

    int number;

    while (stream >> number) {
        if (isSquareNumber(number)) {
            numbers.insert(number);
        }
    }

    print(numbers);

    return 0;
}