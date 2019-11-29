#include <iostream>
#include <algorithm>
#include <vector>

void read(std::vector<std::vector<int>> &matrix, const int rows, const int cols) {
    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            std::cin >> matrix[r][c];
        }
    }
}

void foundSquares(std::vector<std::vector<int>> &matrix, std::vector<int> &sums, const int squareSize,
                  const int targetSum, const int rows, const int cols) {

    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            int endRow = r + squareSize;
            int endCol = c + squareSize;
            int sum = 0;
            if (endRow <= rows && endCol <= cols) {
                for (int i = r; i < endRow; ++i) {
                    for (int j = c; j < endCol; ++j) {
                        sum += matrix[i][j];
                    }
                }

                if (sum >= targetSum) {
                    sum /= squareSize * squareSize;
                    sums.emplace_back(sum);
                }
            }
        }
    }
}

void print(std::vector<int> &sums) {
    for (int num:sums) {
        std::cout << num << ' ';
    }

    std::cout << std::endl;
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    std::vector<int> sums;

    int rows, cols;
    std::cin >> rows >> cols;

    std::vector<std::vector<int>> matrix(rows, std::vector<int>(cols));

    read(matrix, rows, cols);

    int squareSize, targetSum;
    std::cin >> squareSize >> targetSum;

    foundSquares(matrix, sums, squareSize, targetSum, rows, cols);

    sort(sums.begin(), sums.end());

    print(sums);

    return 0;
}