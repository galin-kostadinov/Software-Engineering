#include <iostream>
#include<string>
#include<sstream>

int main() {
    std::string text;
    std::string findWord;
    std::string replaceWord;

    std::getline(std::cin, text);
    std::getline(std::cin, findWord);
    std::getline(std::cin, replaceWord);

    while (text.find(findWord) != std::string::npos) {
        text.replace(text.find(findWord), findWord.size(), replaceWord);
    }

    std::cout << text << std::endl;
    return 0;
}