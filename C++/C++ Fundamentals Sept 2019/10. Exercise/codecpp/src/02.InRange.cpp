#include<iostream>
#include <sstream>
#include <string>
#include <set>

int main() {
    std::string firstLine;
    std::getline(std::cin, firstLine);

    int startNum;
    int endNum;
    std::cin >> startNum >> endNum;

    std::istringstream stream(firstLine);

    std::set<int> numbers;

    int number;

    while (stream >> number) {
        numbers.emplace(number);
    }

    for (int num : numbers) {
        if (num >= startNum && num < endNum) {
            std::cout << num << " ";
        }
    }

    std::cout << std::endl;

    return 0;
}