#include <iostream>
#include<string>

int main() {
    std::string text;
    std::getline(std::cin, text);

    size_t size = text.size();

    for (size_t i = 0; i < size; ++i) {
        if (i == 0 && text[i] != ' ') {
            text[i] = toupper(text[i]);
        } else if (!isalpha(text[i - 1])) {
            text[i] = toupper(text[i]);
        }
    }

    std::cout << text << std::endl;
    return 0;
}