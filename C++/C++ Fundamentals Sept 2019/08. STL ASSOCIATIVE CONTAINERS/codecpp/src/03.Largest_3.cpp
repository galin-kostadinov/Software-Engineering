#include <iostream>
#include <string>
#include <sstream>
#include <set>

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::set<double, std::greater<double>> numbersSet;

    std::istringstream stream(line);

    double currNumber;

    while (stream >> currNumber) {
        numbersSet.insert(currNumber);
    }

    int count = 0;
    for (const auto number : numbersSet) {
        std::cout << number << " ";

        count++;

        if (count == 3) {
            break;
        }
    }

    std::cout << std::endl;

    return 0;
}