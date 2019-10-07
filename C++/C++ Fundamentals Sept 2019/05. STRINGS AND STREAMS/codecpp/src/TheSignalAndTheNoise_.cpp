#include <iostream>
#include<string>
#include<sstream>

int main() {
    std::string line;
    std::getline(std::cin, line);

    while (line.find(" ") != std::string::npos) {
        line.replace(line.find(" "), std::string(" ").size(), "\t\t");
    }

    std::istringstream lineStream(line);
    std::string currentWord;

    uint64_t max = 0;
    bool isFound = false;

    while (lineStream >> currentWord) {
        size_t size = currentWord.size();

        std::string numAsString;
        for (size_t i = 0; i < size; ++i) {
            if (isdigit(currentWord[i])) {
                numAsString += currentWord[i];
            }
        }

        if (!numAsString.empty()) {
            uint64_t num = std::stoll(numAsString);
            isFound = true;
            if (max < num) {
                max = num;
            }
        }
    }

    if (isFound) {
        std::cout << max << std::endl;
    }

    return 0;
}