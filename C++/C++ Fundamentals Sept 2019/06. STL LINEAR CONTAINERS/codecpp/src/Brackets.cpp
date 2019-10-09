#include <iostream>
#include<string>
#include<sstream>
#include <stack>

int main() {
    std::string line;
    getline(std::cin, line);

    std::istringstream lineStream(line);
    char currBracket;

    std::stack<char> curlyBrackets;
    std::stack<char> squareBrackets;
    std::stack<char> parentheses;

    bool isValid = true;
    while (lineStream >> currBracket) {
        switch (currBracket) {
            case '{':
                if (squareBrackets.empty() && parentheses.empty()) {
                    curlyBrackets.push('{');
                } else {
                    isValid = false;
                }
                break;
            case '[':
                if (parentheses.empty()) {
                    squareBrackets.push('[');
                } else {
                    isValid = false;
                }
                break;
            case '(':
                parentheses.push('(');
                break;
            case '}':
                if (squareBrackets.empty() && parentheses.empty() && !curlyBrackets.empty()) {
                    curlyBrackets.pop();
                } else {
                    isValid = false;
                }
                break;
            case ']':
                if (!squareBrackets.empty() && parentheses.empty()) {
                    squareBrackets.pop();
                } else {
                    isValid = false;
                }
                break;
            case ')':
                if (!parentheses.empty()) {
                    parentheses.pop();
                } else {
                    isValid = false;
                }
                break;
            default:
                break;
        }

        if (!isValid) {
            break;
        }
    }

    if (isValid) {
        std::cout << "valid" << std::endl;
    } else {
        std::cout << "invalid" << std::endl;
    }

    return 0;
}