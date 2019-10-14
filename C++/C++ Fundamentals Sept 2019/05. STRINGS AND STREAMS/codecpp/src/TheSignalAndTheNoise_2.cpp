#include <iostream>
#include<string>
#include<sstream>
#include <vector>

int main() {
    std::string line;
    std::getline(std::cin, line);

    if (line.size() == 0) {
        return 0;
    }

    std::istringstream lineStream(line);
    std::string currentWord;
    int max = -1;

    size_t size = line.size();
    for (size_t j = 0; j < size; ++j) {
        std::string currChar = std::to_string(line[j]);
        std::cout << currChar << std::endl;
        std::vector<int> arrNum;
//        while (!(currChar == " " || currChar == " " || currChar == "   ")) {
//
//
//        }

    }


    while (lineStream >> currentWord) {
        size_t size = currentWord.size();

        std::string numAsString;
        for (size_t i = 0; i < size; ++i) {
            if (isdigit(currentWord[i])) {
                numAsString += currentWord[i];
            }
        }
        if (!numAsString.empty()) {
            int num = std::stoi(numAsString);

            if (max < num) {
                max = num;
            }
        }
    }

    if (max != -1) {
        std::cout << max << std::endl;
    }

    return 0;
}