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

int main() {
    int arrSize = 0;
    cin >> arrSize;

    vector<int> arr(arrSize);
    read(arr, arrSize);

    int numToPrint = arr[arrSize - 1];
    int count = 0;

    for (int i = arrSize - 1; i >= 0; --i) {
        int currentNumber = arr[i];
        int currentCount = 0;

        if (currentNumber == numToPrint && i != arrSize - 1) {
            continue;
        }

        for (int j = 0; j < arrSize; ++j) {
            if (currentNumber == arr[j]) {
                currentCount++;
            }
        }

        if (currentCount > count) {
            numToPrint = currentNumber;
            count = currentCount;
        }
    }

    for (int k = 0; k < count; ++k) {
        cout << numToPrint << " ";
    }

    cout << endl;

    return 0;
}