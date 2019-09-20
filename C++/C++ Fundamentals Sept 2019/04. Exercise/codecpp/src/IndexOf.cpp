#include <iostream>
#include <vector>

using namespace std;

void readArray(vector<int> &vector, int arraySize) {
    for (int i = 0; i < arraySize; ++i) {
        cin >> vector[i];
    }
}

int contain(const vector<int> &vector, const int arraySize, const int numberForCheck) {
    int index = -1;

    for (int i = 0; i < arraySize; ++i) {
        if (vector[i] == numberForCheck) {
            index = i;
            break;
        }
    }

    return index;
}

int main() {
    int arraySize = 0;
    cin >> arraySize;

    vector<int> numbers(arraySize);

    readArray(numbers, arraySize);

    int numberForCheck = 0;
    cin >> numberForCheck;

    int index = contain(numbers, arraySize, numberForCheck);

    cout << index << endl;

    return 0;
}

