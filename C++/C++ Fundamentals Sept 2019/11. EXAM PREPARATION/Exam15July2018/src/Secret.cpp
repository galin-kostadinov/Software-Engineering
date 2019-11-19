#include <iostream>
#include <cctype>

int main() {
    char symbol;
    int sum = 0;
    while (std::cin >> symbol && symbol != '.') {
        if (isdigit(symbol)) {
            sum += symbol - '0';
        }
    }

    if (isalpha(sum)) {
        std::cout << (char) sum << std::endl;
    } else {
        std::cout << sum << std::endl;
    }

    return 0;
}