#include <iostream>
#include <vector>
#include <unordered_map>

void readMatrix(std::vector<std::vector<char>> &matrix,
                std::unordered_map<char, std::vector<int>> &firstAppearanceSymbols, const int size) {
    char currChar;
    for (int row = 0; row < size; ++row) {
        for (int col = 0; col < size; ++col) {
            std::cin >> currChar;
            matrix[row][col] = currChar;
            if (currChar != '.') {
                auto it = firstAppearanceSymbols.find(currChar);

                if (it == firstAppearanceSymbols.end()) {
                    firstAppearanceSymbols[currChar] = std::vector<int>{row, col};
                }
            }
        }
    }

}

void foundCenter(std::vector<std::vector<char>> &matrix,
                 std::unordered_map<char, std::vector<int> > &firstAppearanceSymbols,
                 std::unordered_map<char, std::vector<int> > &centerOfTheGlitch) {

    int matrixSize = (int) matrix.size();
    for (auto &kvp : firstAppearanceSymbols) {
        char currSymbol = kvp.first;
        int row = kvp.second[0];
        int col = kvp.second[1];

        for (int r = row; r < matrixSize; r++) {
            if (matrix[r][col] != currSymbol) {
                int centerRow = (r - 1 + row) / 2;
                centerOfTheGlitch[currSymbol] = std::vector<int>{centerRow, col};
                break;
            } else if (r == matrixSize - 1) {
                int centerRow = (r + row) / 2;
                centerOfTheGlitch[currSymbol] = std::vector<int>{centerRow, col};
            }
        }
    }
}

void clearMatrix(std::vector<std::vector<char>> &matrix) {
    int matrixSize = (int) matrix.size();
    for (int row = 0; row < matrixSize; ++row) {
        for (int col = 0; col < matrixSize; ++col) {
            matrix[row][col] = '.';
        }
    }
}

void putCenterOfTheGlitch(std::vector<std::vector<char>> &matrix,
                          std::unordered_map<char, std::vector<int> > &centerOfTheGlitch) {

    for (auto &kvp : centerOfTheGlitch) {
        matrix[kvp.second[0]][kvp.second[1]] = kvp.first;
    }
}

void print(std::vector<std::vector<char>> &matrix) {
    int matrixSize = (int) matrix.size();
    for (int row = 0; row < matrixSize; ++row) {
        for (int col = 0; col < matrixSize; ++col) {
            std::cout << matrix[row][col];
        }

        std::cout << std::endl;
    }
}

int main() {
    int size;
    std::cin >> size;

    std::vector<std::vector<char>> matrix(size, std::vector<char>(size));
    std::unordered_map<char, std::vector<int> > firstAppearanceSymbols;
    std::unordered_map<char, std::vector<int> > centerOfTheGlitch;

    readMatrix(matrix, firstAppearanceSymbols, size);
    foundCenter(matrix, firstAppearanceSymbols, centerOfTheGlitch);
    clearMatrix(matrix);
    putCenterOfTheGlitch(matrix, centerOfTheGlitch);
    print(matrix);

    return 0;
}