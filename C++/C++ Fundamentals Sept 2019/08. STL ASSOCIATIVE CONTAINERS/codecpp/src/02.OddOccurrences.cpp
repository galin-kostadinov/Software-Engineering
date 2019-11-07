#include <iostream>
#include <string>
#include <sstream>
#include <map>
#include <cctype>
#include <algorithm>
#include <vector>

void print(std::map<std::string, int> &wordsCount, std::vector<std::string> &appearanceOrder) {
    bool isFirst = true;
    for (const std::string &word:appearanceOrder) {
        int count = wordsCount.find(word)->second;

        if (count & 1) {
            if (!isFirst) {
                std::cout << ", ";
            }

            std::cout << word;
            isFirst = false;
        }
    }
}

int main() {
    std::string line;
    std::getline(std::cin, line);
    std::transform(line.begin(), line.end(), line.begin(), ::tolower);

    std::map<std::string, int> wordsCount;
    std::vector<std::string> appearanceOrder;

    std::istringstream stream(line);

    std::string word;

    while (stream >> word) {
        if (wordsCount.find(word) == wordsCount.end()) {
            appearanceOrder.push_back(word);
        }

        wordsCount[word]++;
    }

    print(wordsCount, appearanceOrder);
    return 0;
}