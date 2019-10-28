#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>

int main() {
    std::string text;
    getline(std::cin, text);

    std::string word;
    int percentage;

    std::cin >> word >> percentage;

    int textSize = (int) text.size();

    for (int i = 0; i < textSize; ++i) {
        char currChar = text[i];

        if (ispunct(currChar)) {
            text[i] = ' ';
        }
    }

    int counter = 0;

    std::istringstream stream(text);
    std::string currentWord;

    int wordSize = (int) word.size();

    while (stream >> currentWord) {
        int countChars = 0;

        if (currentWord.size() == word.size() && currentWord[0] == word[0]) {
            for (int i = 0; i < wordSize; ++i) {
                if (currentWord[i] == word[i]) {
                    countChars++;
                }
            }
        }

        int currentPercentage = (countChars / (double) wordSize) * 100;

        if (currentPercentage >= percentage) {
            counter++;
        }
    }

    std::cout << counter << std::endl;

    return 0;
}