#include<iostream>
#include <sstream>
#include <string>
#include <set>
#include <unordered_set>

void read(std::unordered_set<std::string> &words) {
    std::string text;
    std::getline(std::cin, text);

    std::istringstream sstr(text);

    std::string word;

    while (sstr >> word) {
        if (ispunct(word[word.size() - 1])) {
            word = word.substr(0, word.size() - 1);
        }

        words.insert(word);
    }
}

void comparator(const std::unordered_set<std::string> &words, std::set<std::string> &matchedWords, const char symbol) {
    for (const auto &word : words) {
        int size = (int) word.size();

        for (int i = 0; i < size; ++i) {
            if (tolower(word[i]) == tolower(symbol)) {
                matchedWords.insert(word);
                break;
            }
        }
    }
}

void print(const std::set<std::string> &matches) {
    if (!matches.empty()) {
        for (auto it = matches.begin(); it != matches.end(); ++it) {
            std::cout << *it << ' ';
        }

        std::cout << std::endl;
    } else {
        std::cout << "---" << std::endl;
    }
}

int main() {
    std::unordered_set<std::string> words;
    std::set<std::string> matchedWords;

    read(words);

    char symbol;

    while (std::cin >> symbol && symbol != '.') {
        comparator(words, matchedWords, symbol);

        print(matchedWords);
        matchedWords.clear();
    }

    return 0;
}