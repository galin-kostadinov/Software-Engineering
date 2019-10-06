#include <iostream>
#include<string>
#include<sstream>
#include <vector>

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::istringstream streamLine(line);

    std::vector<char> stack;

    char currentChar;

    bool isCorrect = true;

    while (streamLine >> currentChar) {
        if (currentChar == '(') {
            stack.push_back('(');
        } else if (currentChar == ')') {
            if (stack.empty()) {
                isCorrect = false;
                break;
            } else {
                stack.pop_back();
            }
        }
    }

    if (!stack.empty()) {
        isCorrect = false;
    }

    if (isCorrect) {
        std::cout << "correct" << std::endl;
    } else {
        std::cout << "incorrect" << std::endl;
    }
    
    return 0;
}