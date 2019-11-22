#include <iostream>
#include <string>
#include <sstream>
#include <stack>

void copy(const std::string &text, std::stack<std::string> &clipboard, int startIndex, int endIndex) {
    startIndex = (int) text.find_last_of(' ', startIndex) + 1;

    endIndex = text.find(' ', endIndex);
    if (endIndex == -1) {
        endIndex = text.size();
    }

    std::string copyPart = text.substr(startIndex, endIndex - startIndex);

    clipboard.push(copyPart);
}

void paste(std::string &text, std::stack<std::string> &clipboard, const int index) {
    if (clipboard.empty()) {
        return;
    }

    std::string pasteText;

    if (text[index] == ' ') {
        pasteText = ' ' + clipboard.top();
    } else {
        pasteText = clipboard.top();
    }
    clipboard.pop();

    text.insert(index, pasteText);
}

int main() {
    std::string text;
    std::getline(std::cin, text);

    std::string command;
    int startIndex = -1;
    int endIndex = -1;

    std::stack<std::string> clipboard;

    std::string input;
    while (std::getline(std::cin, input) && input != "end") {
        std::istringstream stream(input);
        stream >> command;

        if (command == "copy") {
            stream >> startIndex;
            stream >> endIndex;

            copy(text, clipboard, startIndex, endIndex);
        } else {
            stream >> startIndex;
            endIndex = -1;

            paste(text, clipboard, startIndex);
        }
    }

    std::cout << text << std::endl;

    return 0;
}
