#include <iostream>
#include<string>
#include<sstream>
#include<vector>

void readArray(std::vector<std::vector<int>> &matrixNums, int rows) {
    for (int i = 0; i < rows; ++i) {
        std::string line;
        getline(std::cin, line);
        std::istringstream lineStream(line);
        int currentNumber;
        while (lineStream >> currentNumber) {
            matrixNums[i].push_back(currentNumber);
        }
    }
}

int main() {
    std::string line;

    getline(std::cin, line);
    int rowsFirstArray = stoi(line);
    std::vector<std::vector<int>> firstArray(rowsFirstArray);
    readArray(firstArray, rowsFirstArray);

    getline(std::cin, line);
    int rowsSecondArray = stoi(line);
    std::vector<std::vector<int>> secondArray(rowsSecondArray);
    readArray(secondArray, rowsSecondArray);

    if (firstArray == secondArray) {
        std::cout << "equal" << std::endl;
    } else {
        std::cout << "not equal" << std::endl;
    }

    return 0;
}