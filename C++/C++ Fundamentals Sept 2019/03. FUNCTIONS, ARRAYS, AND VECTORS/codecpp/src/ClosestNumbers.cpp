#include<iostream>
#include <vector>
#include <cmath>

using namespace std;

void read(vector<int> &numbers, int size) {
    for (int i = 0; i < size; ++i) {
        cin >> numbers[i];
    }
}

int main() {
    int arrSize = 0;
    cin >> arrSize;

    vector<int> arr(arrSize);
    read(arr, arrSize);

    int absDiff = INT_MAX;

    for (int i = 0; i < arrSize; ++i) {
        for (int j = i + 1; j < arrSize; ++j) {
            int currentDiff = abs(arr[i] - arr[j]);
            if (currentDiff < absDiff) {
                absDiff = currentDiff;
            }
        }
    }

    if (arrSize == 1) {
        absDiff = 0;
    }

    cout << absDiff << endl;

    return 0;
}
