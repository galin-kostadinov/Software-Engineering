#include <iostream>
#include <map>
#include <string>
#include <sstream>

void readMessagesContainingWord(std::map<int, std::string> &messages, std::string &word) {
    std::string line;
    std::string currWord;

    while (getline(std::cin, line) && line != ".") {
        int count = 0;
        std::istringstream iss(line);

        while (iss >> currWord) {
            if (currWord == word) {
                count++;
            }
        }

        if (count > 0) {
            messages[count] = line;
        }
    }
}

void printRelevantMessages(std::map<int, std::string> &messages, int pageSize) {
    int count = 0;

    std::map<int, std::string>::reverse_iterator it;

    for (it = messages.rbegin(); it != messages.rend(); it++) {
        if (count >= pageSize) {
            break;
        }
        std::cout << it->second << std::endl;
        count++;
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    std::string word;
    int pageSize;
    std::cin >> word >> pageSize;

    std::map<int, std::string> messages;

    readMessagesContainingWord(messages, word);

    printRelevantMessages(messages, pageSize);

    return 0;
}