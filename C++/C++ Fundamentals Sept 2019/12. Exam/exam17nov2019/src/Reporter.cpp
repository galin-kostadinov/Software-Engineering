#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <unordered_set>

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int lineNumber;
    std::cin >> lineNumber;
    std::cin.ignore();

    std::ostringstream oss;

    std::unordered_set<std::string> foundWord;
    std::string line;
    while (lineNumber-- > 0) {
        getline(std::cin, line);

        std::istringstream iss(line);
        std::string word;
        while (iss >> word) {
            if (word == ".") {
                oss << '.' << ' ';
                foundWord.clear();
            } else {
                if (foundWord.find(word) == foundWord.end()) {
                    oss << word << ' ';
                    foundWord.emplace(word);
                }
            }
        }

    }

    std::cout << oss.str() << std::endl;

    return 0;
}