#include <iostream>
#include <vector>

int main() {
    std::string text;
    std::getline(std::cin, text);

    int size = 26;
    std::vector<bool> containedLetters(size);

    int sizeText = (int) text.size();
    for (int i = 0; i < sizeText; ++i) {
        int index = text[i] - 'a';
        containedLetters[index] = true;
    }

    for (int i = 0; i < size; ++i) {
        if (!containedLetters[i]) {
            std::cout << char(i + 'a');
        }
    }
    std::cout << std::endl;

    return 0;
}