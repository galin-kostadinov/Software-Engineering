#include <iostream>
#include <vector>

void readArray(std::vector<int> &vector, int arraySize) {
    for (int i = 0; i < arraySize; ++i) {
        std::cin >> vector[i];
    }
}

void readNumbersFromArray(std::vector<int> &newArray, const std::vector<int> &numbers, int removeIndex) {
    for (int i = 0; i < removeIndex; ++i) {
        newArray[i] = numbers[i];
    }

    for (size_t i = removeIndex + 1; i < numbers.size(); ++i) {
        newArray[i - 1] = numbers[i];
    }
}

void printArray(const std::vector<int> &numbers) {
    for (size_t i = 0; i < numbers.size(); ++i) {
        std::cout << numbers[i] << " ";
    }

    std::cout << std::endl;
}

int main() {
    int size = 0;
    std::cin >> size;

    std::vector<int> numbers(size);
    readArray(numbers, size);

    for (size_t i = 0; i < numbers.size() - 1; ++i) {
        if (numbers[i] == numbers[i + 1]) {
            numbers[i] = numbers[i] * 2;
            std::vector<int> newArray(numbers.size() - 1);
            readNumbersFromArray(newArray, numbers, i + 1);
            numbers = newArray;

            i = -1;
        }
    }

    printArray(numbers);

    return 0;
}