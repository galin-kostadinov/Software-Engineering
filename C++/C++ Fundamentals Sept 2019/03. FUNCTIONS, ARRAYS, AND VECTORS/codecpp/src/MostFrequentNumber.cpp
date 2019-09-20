#include<iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

void read(vector<int> &numbers, int size) {
    for (int i = 0; i < size; ++i) {
        cin >> numbers[i];
    }
}

bool contains(vector<int> &vector, int number) {
    int size = vector.size();

    for (int i = 0; i < size; ++i) {
        if (vector[i] == number) {
            return true;
        }
    }

    return false;
}

void print(vector<int> &vector) {
    int size = vector.size();
    for (int i = 0; i < size; ++i) {
        cout << vector[i] << " ";
    }
}

int main() {
    int arrSize = 0;
    cin >> arrSize;

    vector<int> arr(arrSize);
    read(arr, arrSize);

    vector<int> arrWithMostFrequentNumbers;
    int count = 0;

    for (int i = 0; i < arrSize; ++i) {
        int currentNumber = arr[i];
        int currentCount = 0;

        if (contains(arrWithMostFrequentNumbers, currentNumber)) {
            continue;
        }

        if (arrWithMostFrequentNumbers.empty()) {
            arrWithMostFrequentNumbers.push_back(currentNumber);
            count = 1;
        }

        for (int j = 0; j < arrSize; ++j) {
            if (currentNumber == arr[j]) {
                currentCount++;
            }
        }

        if (currentCount > count) {
            arrWithMostFrequentNumbers.clear();
            arrWithMostFrequentNumbers.push_back(currentNumber);
            count = currentCount;
        } else if (currentCount == count) {
            if (!contains(arrWithMostFrequentNumbers, currentNumber)) {
                arrWithMostFrequentNumbers.push_back(currentNumber);
            }
        }
    }

    sort(arrWithMostFrequentNumbers.begin(), arrWithMostFrequentNumbers.end());
    print(arrWithMostFrequentNumbers);

    return 0;
}