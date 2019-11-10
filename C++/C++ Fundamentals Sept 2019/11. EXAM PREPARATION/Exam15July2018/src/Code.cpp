#include <iostream>
#include <sstream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

void readSeparators(unordered_set<int> &separators) {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    string line;
    getline(cin, line);

    istringstream iss(line);
    int number = 0;

    while (iss >> number) {
        separators.emplace(number);
    }
}

void readNumbersGroups(unordered_map<int, int> &numbersCount,
                       const unordered_set<int> &separators) {
    unordered_set<int> currGroup;
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    string line;
    getline(cin, line);

    istringstream iss(line);
    int number = 0;

    if (!separators.empty()) {
        while (iss >> number) {
            if (separators.count(number)) {
                if (currGroup.emplace(number).second) {
                    numbersCount[number]++;
                }
            } else {
                currGroup.clear();
            }
        }
    } else {
        while (iss >> number) {
            if (currGroup.emplace(number).second) {
                numbersCount[number]++;
            } else {
                currGroup.clear();
            }
        }
    }

    while (iss >> number) {
        if (separators.find(number) == separators.end()) {
            if (currGroup.emplace(number).second) {
                numbersCount[number]++;
            }
        } else {
            currGroup.clear();
        }
    }
}


int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    unordered_set<int> separators;
    unordered_map<int, int> numbersCount;

    readSeparators(separators);
    readNumbersGroups(numbersCount, separators);

    int searchingNumber = 0;
    while (cin >> searchingNumber && searchingNumber != 0) {
        if (numbersCount.count(searchingNumber)) {
            std::cout << numbersCount[searchingNumber] << std::endl;
        } else {
            std::cout << 0 << std::endl;
        }
    }

    return 0;
}