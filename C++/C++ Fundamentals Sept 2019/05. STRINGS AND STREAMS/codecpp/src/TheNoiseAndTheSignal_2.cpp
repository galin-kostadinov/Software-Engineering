#include <iostream>
#include<string>
#include<sstream>
#include <vector>

using namespace std;

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::istringstream lineStream(line);
    std::string currentWord;

    std::string noise;

    while (lineStream >> currentWord) {
        size_t size = (int) currentWord.size();
        std::string currNoise;
        for (size_t i = 0; i < size; ++i) {
            char16_t c = currentWord[i];
            if (isdigit(c)) {
                currentWord[i] = ' ';
            }
        }

        std::istringstream currentWordStream(currentWord);
        std::string currentWord2;

        while (currentWordStream >> currentWord2) {
            currNoise += currentWord2;
        }

        if (noise.empty()) {
            noise = currNoise;

        } else if (currNoise.size() >= noise.size()) {
            if (currNoise < noise) {
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