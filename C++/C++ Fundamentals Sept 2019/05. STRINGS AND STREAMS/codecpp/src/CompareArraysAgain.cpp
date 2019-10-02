#include <iostream>
#include<string>
#include<sstream>
#include<vector>

void read(std::vector<int> &numbers, const std::string line) {
    std::istringstream lineStream(line);
    int currentNumber;
    while (lineStream >> currentNumber) {
        numbers.push_back(currentNumber);
    }
}

bool areEqual(std::vector<int> &firstArr, std::vector<int> &secondArr) {
    int sizeFirstArr = (int) firstArr.size();
    int sizeSecondArr = (int) secondArr.size();

    if (sizeFirstArr != sizeSecondArr) {
        return false;
    } else {
        for (int i = 0; i < sizeFirstArr; ++i) {
            if (firstArr[i] != secondArr[i]) {
                return false;
            }
        }
    }

    return true;
}

int main() {
    std::string line;

    std::vector<int> firstArray;
    std::vector<int> secondArray;

    std::getline(std::cin, line);
    read(firstArray, line);

    std::getline(std::cin, line);
    read(secondArray, line);

    if (areEqual(firstArray, secondArray)) {
        std::cout << "equal" << std::endl;
    } else {
        std::cout << "not equal" << std::endl;
    }

    return 0;
}