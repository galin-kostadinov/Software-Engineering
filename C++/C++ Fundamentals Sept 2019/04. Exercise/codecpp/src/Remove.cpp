#include <iostream>
#include<vector>

using namespace std;

void readArray(vector<int> &numbers, int arraySize) {
    for (int i = 0; i < arraySize; ++i) {
        cin >> numbers[i];
    }
}

void printWithoutNumber(vector<int> &numbers, int arraySize, int numberToRemove) {
    for (int number: numbers) {
        if (number != numberToRemove) {
            cout << number << " ";
        }
    }
    cout << endl;
}

int main() {
    int arraySize = 0;
    cin >> arraySize;

    vector<int> numbers(arraySize);

    readArray(numbers, arraySize);

    int numberToRemove = 0;
    cin >> numberToRemove;

    printWithoutNumber(numbers, arraySize, numberToRemove);

    return 0;
}