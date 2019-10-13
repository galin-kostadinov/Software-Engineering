#include<iostream>
#include<vector>

void read(std::vector<int> &arr, size_t size) {

    for (size_t i = 0; i < size; ++i) {
        int number;
        std::cin >> number;
        arr[i] += number;
    }
}

int main() {
    size_t size, lines;
    std::cin >> lines >> size;

    std::vector<int> arr(size);

    for (size_t i = 0; i < lines; ++i) {
        read(arr, size);
    }

    int mod;
    std::cin >> mod;

    for (size_t i = 0; i < size; ++i) {
        arr[i] %= mod;
    }

    for (size_t i = 0; i < size; ++i) {
        std::cout << arr[i] << " ";
    }
    return 0;
}