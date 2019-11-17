#include <iostream>
#include <map>
#include <vector>

int main() {
    std::string word;

    std::map<std::string, int> countOfWords;
    std::map<int, std::vector<std::string>> sortedByCount;


    while (std::cin >> word && word != ".") {
        ++countOfWords[word];
    }

    int numberOfQueries;
    std::cin >> numberOfQueries;

    int count, index;

    while (numberOfQueries-- > 0) {
        std::cin >> count >> index;

        std::vector<std::string> words;

        if (sortedByCount.find(count) != sortedByCount.end()) {
            words = sortedByCount[count];
        } else {
            for (const auto &item : countOfWords) {
                if (item.second == count) {
                    words.push_back(item.first);
                }
            }

            sortedByCount[count] = words;
        }

        if (index < words.size()) {
            std::cout << words[index] << std::endl;
        } else {
            std::cout << '.' << std::endl;
        }
    }

    return 0;
}
