#include<iostream>
#include <vector>

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

    int sum = 0;
    for (int i = 0; i < arrSize; ++i) {
        sum += arr[i];
    }

    int averageSum = sum / arrSize;

    for (int i = 0; i < arrSize; ++i) {
        if (arr[i] >= averageSum) {
            cout << arr[i] << " ";
        }
    }

    cout << endl;

    return 0;
}
