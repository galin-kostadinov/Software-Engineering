#include<iostream>
#include <sstream>
#include <string>
#include <set>
#include <unordered_set>

void read(std::unordered_set<int> &numbers) {
    std::string line;
    std::getline(std::cin, line);

    std::istringstream sstr(line);

    int number;

    while (sstr >> number) {
        numbers.insert(number);
    }
}

std::set<int>
intersection(const std::unordered_set<int> &firstSequence, const std::unordered_set<int> &secondSequence) {
    std::set<int> matches;

    for (const int number : firstSequence) {
        if (secondSequence.find(number) != secondSequence.end()) {
            matches.insert(number);
        }
    }

    return matches;
}

void print(const std::set<int> &matches) {
    if (!matches.empty()) {
        for (auto it = matches.begin(); it != matches.end(); ++it) {
            std::cout << *it << ' ';
        }

        std::cout << std::endl;
    } else {
        std::cout << "no matches" << std::endl;
    }
}

int main() {
    std::unordered_set<int> firstSequence;
    std::unordered_set<int> secondSequence;

    read(firstSequence);
    read(secondSequence);

    std::set<int> matches = intersection(firstSequence, secondSequence);

    print(matches);

    return 0;
}