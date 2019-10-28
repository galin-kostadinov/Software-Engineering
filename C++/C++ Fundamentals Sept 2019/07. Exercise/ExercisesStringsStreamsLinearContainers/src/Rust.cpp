#include <iostream>
#include <vector>
#include <queue>

void readMatrix(std::vector<std::vector<char>> &matrixSymbol, const int row, const int col) {
    for (int r = 0; r < row; ++r) {
        for (int c = 0; c < col; ++c) {
            std::cin >> matrixSymbol[r][c];
        }
    }
}

void initialSearchRustIndexes(std::queue<int> &rowsIndexesQueue, std::queue<int> &colsIndexesQueue,
                              std::vector<std::vector<char>> &matrixSymbol) {
    int rowSize = (int) matrixSymbol.size();
    int colSize = (int) matrixSymbol[0].size();

    for (int r = 0; r < rowSize; ++r) {
        for (int c = 0; c < colSize; ++c) {
            if (matrixSymbol[r][c] == '!') {
                rowsIndexesQueue.push(r);
                colsIndexesQueue.push(c);
            }
        }
    }
}

bool isInBound(const int rowIndex, const int colIndex, const int rowsSize, const int colsSize) {
    return rowIndex >= 0 && rowIndex < rowsSize && colIndex >= 0 && colIndex < colsSize;
}

void spreadRust(std::queue<int> &rowsIndexesQueue, std::queue<int> &colsIndexesQueue,
                std::vector<std::vector<char>> &matrixSymbol) {
    int rowSize = (int) matrixSymbol.size();
    int colSize = (int) matrixSymbol[0].size();

    int queueRustSize = (int) rowsIndexesQueue.size();

    while (queueRustSize-- > 0) {
        int indexRowMine = rowsIndexesQueue.front();
        rowsIndexesQueue.pop();
        int indexColMine = colsIndexesQueue.front();
        colsIndexesQueue.pop();

        int up = indexRowMine - 1;
        int down = indexRowMine + 1;
        int left = indexColMine - 1;
        int right = indexColMine + 1;

        if (isInBound(up, indexColMine, rowSize, colSize)) {
            if (matrixSymbol[up][indexColMine] != '!' && matrixSymbol[up][indexColMine] != '#') {
                matrixSymbol[up][indexColMine] = '!';
                rowsIndexesQueue.push(up);
                colsIndexesQueue.push(indexColMine);
            }
        }
        if (isInBound(down, indexColMine, rowSize, colSize)) {
            if (matrixSymbol[down][indexColMine] != '!' && matrixSymbol[down][indexColMine] != '#') {
                matrixSymbol[down][indexColMine] = '!';
                rowsIndexesQueue.push(down);
                colsIndexesQueue.push(indexColMine);
            }
        }

        if (isInBound(indexRowMine, left, rowSize, colSize)) {
            if (matrixSymbol[indexRowMine][left] != '!' && matrixSymbol[indexRowMine][left] != '#') {
                matrixSymbol[indexRowMine][left] = '!';
                rowsIndexesQueue.push(indexRowMine);
                colsIndexesQueue.push(left);
            }
        }

        if (isInBound(indexRowMine, right, rowSize, colSize)) {
            if (matrixSymbol[indexRowMine][right] != '!' && matrixSymbol[indexRowMine][right] != '#') {
                matrixSymbol[indexRowMine][right] = '!';
                rowsIndexesQueue.push(indexRowMine);
                colsIndexesQueue.push(right);
            }
        }
    }
}

void printMatrix(std::vector<std::vector<char>> &matrixDigit, const int row, const int col) {
    for (int r = 0; r < row; ++r) {
        for (int c = 0; c < col; ++c) {
            std::cout << matrixDigit[r][c];
        }

        std::cout << std::endl;
    }
}

int main() {
    int row = 10;
    int col = 10;

    std::vector<std::vector<char>> matrixSymbol(row, std::vector<char>(col));
    std::queue<int> rowsIndexesRust;
    std::queue<int> colsIndexesRust;

    readMatrix(matrixSymbol, row, col);

    initialSearchRustIndexes(rowsIndexesRust, colsIndexesRust, matrixSymbol);

    int cycles;
    std::cin >> cycles;

    while (cycles-- > 0) {
        spreadRust(rowsIndexesRust, colsIndexesRust, matrixSymbol);
    }

    printMatrix(matrixSymbol, row, col);

    return 0;
}