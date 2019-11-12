#include <iostream>
#include <string>
#include <cctype>

int main() {
    int length;
    std::string first;
    std::string second;

    std::cin >> length >> first >> second;

    char symbolFirst;
    char symbolSecond;

    int count = 0;

    for (int i = 0; i < length; ++i) {
        symbolFirst = first[i];
        symbolSecond = second[i];

        if (symbolFirst == symbolSecond) {
            std::cout << symbolFirst;
        } else if (toupper(symbolFirst) == toupper(symbolSecond)) {
            std::cout << (char) toupper(symbolFirst);
        } else {
            std::cout << '!';
            count++;
        }

    }

    std::cout << std::endl << count << std::endl;

    return 0;
}