#include <iostream>
#include <string>
#include <stack>

void readWord(std::stack<std::string> &stackWords) {
    std::string currentWord;
    std::cin >> currentWord;

    while ("end" != currentWord) {
        stackWords.push(currentWord);
        std::cin >> currentWord;
    }
}

void printWord(std::stack<std::string> &stackWords) {
    while (!stackWords.empty()) {
        std::cout << stackWords.top() << " ";
        stackWords.pop();
    }

    std::cout << std::endl;
}

int main() {
    std::stack<std::string> stackWords;

    readWord(stackWords);
    printWord(stackWords);

    return 0;
}