#include <iostream>
#include <vector>
#include <cmath>

void readNumbers(std::vector<std::vector<int>> &matrix, int size) {
    for (int row = 0; row < size; ++row) {
        for (int col = 0; col < size; ++col) {
            std:: cin >> matrix[row][col];
        }
    }
}

bool checkIsSimpleNumber(int currNumber) {
    if (currNumber == 1 || currNumber == 2 || currNumber == 3) {
        return true;
    }

    int last = sqrt(currNumber);

    for (int i = 2; i <= last; ++i) {
        if (currNumber % i == 0) {
            return false;
        }
    }

    return true;
}

int sumSimpleNumberBelowTwoDiagonals(std::vector<std::vector<int>> &matrix, int size) {
    int sum = 0;
    int endRow = size / 2 + 1;

    int i = 1;
    for (int row = size - 1; row >= endRow; --row) {
        for (int col = size - 1 - i; col >= i; --col) {
            int currNumber = matrix[row][col];
            if (checkIsSimpleNumber(currNumber)) {
                sum += currNumber;
            }
        }

        i++;
    }

    return sum;
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int size;
    std::cin >> size;

    std::vector<std::vector<int>> matrix(size, std::vector<int>(size));

    readNumbers(matrix, size);

    int sum = 0;

    sum = sumSimpleNumberBelowTwoDiagonals(matrix, size);

    std::cout << sum << std::endl;

    return 0;
}
