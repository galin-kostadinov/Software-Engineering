#include <iostream>
#include<iomanip>
#include <vector>

void filler(int, int, std::vector<std::vector<char>> &, const int, const int, const char, const char);

void readMatrix(std::vector<std::vector<char>> &matrix, const int rowMatrix, const int colMatrix) {
    std::cin.sync_with_stdio(false);
    for (int r = 0; r < rowMatrix; r++) {
        for (int c = 0; c < colMatrix; c++) {
            std::cin >> matrix[r][c];
        }
    }
}

void printMatrix(std::vector<std::vector<char>> &matrix, const int rowMatrix, const int colMatrix) {
    std::cout.sync_with_stdio(false);
    for (int row = 0; row < rowMatrix; row++) {
        for (int col = 0; col < colMatrix; col++) {
            std::cout << matrix[row][col];
        }
        std::cout << std::endl;
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int rowMatrix = 0;
    int colMatrix = 0;
    std::cin >> rowMatrix >> colMatrix;

    std::vector<std::vector<char>> matrix(rowMatrix, std::vector<char>(colMatrix));

    readMatrix(matrix, rowMatrix, colMatrix);

    char fillChar;
    int startRow = 0;
    int startCol = 0;

    std::cin >> fillChar >> startRow >> startCol;

    char startChar = matrix[startRow][startCol];

    int row = startRow;
    int col = startCol;

    filler(startRow, startCol, matrix, rowMatrix, colMatrix, fillChar, startChar);

    printMatrix(matrix, rowMatrix, colMatrix);

    return 0;
}

void filler(int row, int col, std::vector<std::vector<char>> &arr, const int rows, const int columns,
            const char fill_char, const char start_char) {

    arr[row][col] = fill_char;

    if (row + 1 < rows && arr[row + 1][col] == start_char) {
        filler(row + 1, col, arr, rows, columns, fill_char, start_char);
    }

    if (row - 1 >= 0 && arr[row - 1][col] == start_char) {
        filler(row - 1, col, arr, rows, columns, fill_char, start_char);
    }

    if (col + 1 < columns && arr[row][col + 1] == start_char) {
        filler(row, col + 1, arr, rows, columns, fill_char, start_char);
    }

    if (col - 1 >= 0 && arr[row][col - 1] == start_char) {
        filler(row, col - 1, arr, rows, columns, fill_char, start_char);
    }
}