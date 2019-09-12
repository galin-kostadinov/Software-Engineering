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

    for (int i = 0; i < arrSize; ++i) {
        for (int j = 0; j < arrSize; ++j) {
            cout << arr[i] * arr[j] << " ";
        }
    }

    cout << endl;

    return 0;
}
