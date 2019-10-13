#include<iostream>
#include<vector>
#include <cmath>

void read(std::vector<int> &arr, int size) {

    for (int i = 0; i < size; ++i) {
        std::cin >> arr[i];
    }
}

int main() {
    int size;
    std::cin >> size;

    std::vector<int> buses(size);
    read(buses, size);

    int train;
    std::cin >> train;

    int bestIndex = 0;
    int bestTime = INT_MAX;

    for (int i = 0; i < size; ++i) {
        if (abs(train - buses[i]) <= bestTime) {
            bestTime = abs(train - buses[i]);
            bestIndex = i;
        }
    }

    std::cout << bestIndex + 1 << std::endl;

    return 0;
}