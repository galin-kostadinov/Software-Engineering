#include<iostream>
#include<vector>

void read(std::vector<size_t> &arr, size_t size) {

    for (size_t i = 0; i < size; ++i) {
        std::cin >> arr[i];
    }
}

int main() {
    size_t size;
    std::cin >> size;

    std::vector<size_t> checkup(size);
    std::vector<size_t> installation(size);
    std::vector<size_t> lifetimes(size);

    read(checkup, size);
    read(installation, size);


    std::vector<size_t> lifetimesByYear(size);

    for (size_t i = 0; i < size; ++i) {
        lifetimesByYear[i] = installation[i] - checkup[i];
    }

    for (size_t i = 0; i < size; ++i) {
        lifetimes[i] = installation[i] / lifetimesByYear[i];
    }

    for (size_t i = 0; i < size; ++i) {
        std::cout << lifetimes[i] << " ";
    }

    std::cout << std::endl;

    return 0;
}