#include <iostream>
#include <string>
#include <sstream>
#include <set>

void print(std::set<double> &numbers) {
    bool isFirst = true;
    for (const double number : numbers) {
        if (!isFirst) {
            std::cout << " <= ";
        }
        std::cout << number;
        isFirst = false;
    }
}

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::set<double> numbers;

    std::istringstream stream(line);

    double number;

    while (stream >> number) {
        numbers.insert(number);
    }

    print(numbers);

    return 0;
}