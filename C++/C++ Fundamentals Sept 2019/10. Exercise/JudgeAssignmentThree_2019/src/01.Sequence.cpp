#include <iostream>

int main() {
    int count;
    std::cin >> count;

    int max = 0;
    int secondMax = 0;
    int currentNumber = 0;
    int lastNumber = 0;
    for (int i = 0; i < count; ++i) {
        std::cin >> currentNumber;

        if (i == 0) {
            secondMax++;
        } else {
            if (currentNumber > lastNumber) {
                secondMax++;
            } else {
                if (max < secondMax) {
                    max = secondMax;
                }
                secondMax = 1;
            }
        }

        lastNumber = currentNumber;
    }

    if (max >= secondMax) {
        std::cout << max << std::endl;
    } else {
        std::cout << secondMax << std::endl;
    }

    return 0;
}
