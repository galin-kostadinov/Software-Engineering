#include<iostream>
#include <vector>

using namespace std;

void read(vector<int> &numbers, int size) {
    for (int i = 0; i < size; ++i) {
        cin >> numbers[i];
    }
}

bool areEqual(vector<int> &firstArr, int sizeFirstArr, vector<int> &secondArr, int sizeSecondArr) {
    if (sizeFirstArr != sizeSecondArr) {
        return false;
    } else {
        for (int i = 0; i < sizeFirstArr; ++i) {
            if (firstArr[i] != secondArr[i]) {
                return false;
            }
        }
    }

    return true;
}

int main() {
    int firstArrSize = 0;
    cin >> firstArrSize;

    vector<int> firstArr(firstArrSize);
    read(firstArr, firstArrSize);

    int secondArrSize = 0;
    cin >> secondArrSize;

    vector<int> secondArr(secondArrSize);
    read(secondArr, secondArrSize);

    if (areEqual(firstArr, firstArrSize, secondArr, secondArrSize)) {
        cout << "equal" << endl;
    } else {
        cout << "not equal" << endl;
    }

    return 0;
}
