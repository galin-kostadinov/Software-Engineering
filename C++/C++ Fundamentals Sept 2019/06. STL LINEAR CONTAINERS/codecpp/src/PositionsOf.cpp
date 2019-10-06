#include <iostream>
#include<vector>

void readArray(std::vector<std::vector<int>> &matrixNums, const int rows, const int cols) {

    for (int row = 0; row < rows; ++row) {
        matrixNums[row].reserve(cols);
        for (int col = 0; col < cols; ++col) {
            std::cin >> matrixNums[row][col];
        }
    }
}

int main() {
    int rowsArray, colsArray;

    std::cin >> rowsArray >> colsArray;

    std::vector<std::vector<int>> matrix(rowsArray);
    readArray(matrix, rowsArray, colsArray);

    int number;
    std::cin >> number;

    bool isFound = false;
    for (int row = 0; row < rowsArray; ++row) {
        for (int col = 0; col < colsArray; ++col) {
            if (matrix[row][col] == number) {
                std::cout << row << " " << col << std::endl;
                isFound = true;
            }
        }
    }

    if (!isFound) {
        std::cout << "not found" << std::endl;
    }

    return 0;
}