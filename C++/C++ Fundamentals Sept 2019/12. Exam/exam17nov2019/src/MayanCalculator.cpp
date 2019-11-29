#include <iostream>
#include <string>
#include <sstream>
#include <vector>

void readSystem(std::vector<std::vector<std::string>> &systems, std::string &line) {
    istringstream iss(line);

    int lineSize = line.size();
    int count = lineSize / 10;

    char currChar;
    std::string accumulator;

    std::vector<std::string> currSystem;

    for (int i = 0; i < lineSize; i += count) {
        for (int j = 0; j < count; ++j) {
            iss >> currChar;
            accumulator.push_back(currChar);
        }
        currSystem.emplace_back(accumulator);
        accumulator.clear();
    }

    systems.emplace_back(currSystem);
}

void print(std::vector<std::vector<std::string>> &systems, std::string &number, int index) {
    std::vector<std::string> currSystem = systems[index];

    int numberSize = (int) number.size();

    std::ostringstream oss;

    int currNumber = 0;
    for (int i = 0; i < numberSize; ++i) {
        currNumber = number[i] - '0';
        oss << currSystem[currNumber];
    }

    cout << oss.str() << std::endl;
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int operationsCount;
    std::cin >> operationsCount;
    std::cin.ignore();

    std::vector<std::vector<std::string>> systems;

    std::string line;
    while (operationsCount-- > 0) {
        getline(std::cin, line);

        readSystem(systems, line);
    }

    string number;
    getline(std::cin, number);


    int size = (int) systems.size();
    for (int i = 0; i < size; ++i) {
        print(systems, number, i);
    }

    return 0;
}