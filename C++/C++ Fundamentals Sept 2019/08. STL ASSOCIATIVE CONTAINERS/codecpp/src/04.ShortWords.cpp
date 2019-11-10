#include <iostream>
#include <string>
#include <sstream>
#include <set>
#include <algorithm>
#include <cctype>

void print(std::set<std::string> &words) {
    bool isFirst = true;
    for (const std::string &word : words) {
        if (!isFirst) {
            std::cout << ", ";
        } else {
            isFirst = false;
        }
        std::cout << word;
    }
}

int main() {
    std::string line;
    std::getline(std::cin, line);
    std::transform(line.begin(), line.end(), line.begin(), ::tolower);

    std::set<std::string> words;

    std::istringstream stream(line);

    std::string word;

    while (stream >> word) {
        if (word.size() < 5) {
            words.insert(word);
        }
    }

    print(words);

    return 0;
}