#include <iostream>
#include<string>
#include<sstream>

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::istringstream lineStream(line);
    std::string currentWord;

    std::string noise = std::string("");

    while (lineStream >> currentWord) {
        size_t size = currentWord.size();

        std::string currNoise = std::string("");
        for (size_t i = 0; i < size; ++i) {
            if (!isdigit(currentWord[i])) {
                currNoise += currentWord[i];
            }
        }

        if (noise.empty()) {
            noise = currNoise;
        } else if (currNoise.size() >= noise.size()) {
            if (currNoise.size() > noise.size()) {
                noise = currNoise;
            } else if (currNoise < noise) {
                noise = currNoise;
            }
        }
    }

    if (!noise.empty()) {
        std::cout << noise << std::endl;
    } else {
        std::cout << "no noise" << std::endl;
    }

    return 0;
}