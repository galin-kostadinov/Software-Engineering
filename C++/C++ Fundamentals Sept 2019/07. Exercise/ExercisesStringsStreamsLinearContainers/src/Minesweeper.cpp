#include <iostream>
#include <vector>

void readMatrix(std::vector<std::vector<char>> &matrixSymbol, const int row, const int col) {
    for (int r = 0; r < row; ++r) {
        for (int c = 0; c < col; ++c) {
            std::cin >> matrixSymbol[r][c];
        }
    }
}

void increaseValuesInMatrixDigit(std::vector<std::vector<int>> &matrixDigit, const int indexRowMine,
                                 const int indexColMine, const int rowSize, const int colSize) {

    int up = indexRowMine - 1;
    int down = indexRowMine + 1;
    int left = indexColMine - 1;
    int right = indexColMine + 1;

    if (up < 0) {
        up = 0;
    }
    if (down > rowSize - 1) {
        down = rowSize - 1;
    }

    if (left < 0) {
        left = 0;
    }
    if (right > colSize - 1) {
        right = colSize - 1;
    }

    for (int r = up; r <= down; ++r) {
        for (int c = left; c <= right; ++c) {
            matrixDigit[r][c]++;
        }
    }
}

void printMatrix(std::vector<std::vector<int>> &matrixDigit, const int row, const int col) {
    for (int r = 0; r < row; ++r) {
        for (int c = 0; c < col; ++c) {
            std::cout << matrixDigit[r][c];
        }
        std::cout << std::endl;
    }
}

void searchMines(std::vector<std::vector<char>> &matrixSymbol, std::vector<std::vector<int>> &matrixDigit, const int row,
            const int col) {
    for (int r = 0; r < row; ++r) {
        for (int c = 0; c < col; ++c) {
            if (matrixSymbol[r][c] == '!') {
                increaseValuesInMatrixDigit(matrixDigit, r, c, row, col);
            }
        }
    }
}

int main() {
    int row;
    int col;
    std::cin >> row >> col;
    std::cin.ignore();

    std::vector<std::vector<char>> matrixSymbol(row, std::vector<char>(col));
//    matrixSymbol.reserve(row);
//    matrixSymbol[index].reserve(col)

    std::vector<std::vector<int>> matrixDigit(row, std::vector<int>(col));;

    readMatrix(matrixSymbol, row, col);

    searchMines(matrixSymbol, matrixDigit, row, col);

    printMatrix(matrixDigit,row, col);

    return 0;
}