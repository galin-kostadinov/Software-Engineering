#include<iostream>
#include <map>
#include <sstream>
#include <string>

enum Indexes {
    EVEN_ELEMENT,
    ODD_ELEMENT,
    INDEXES_COUNT
};

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::istringstream stream(line);

    std::map<std::string, int> words;

    std::string word;

    while (stream >> word) {
        ++words[word];
    }

    std::ostringstream element[INDEXES_COUNT];

    for (const auto &item : words) {
        //  element[item.second & 1] << item.first << " ";
        if (item.second & 1) {
            element[ODD_ELEMENT] << item.first << " ";
        } else {
            element[EVEN_ELEMENT] << item.first << " ";
        }
    }

    std::cout << element[ODD_ELEMENT].str() << std::endl << element[EVEN_ELEMENT].str() << std::endl;

    return 0;
}