#include <iostream>
#include <string>
#include <cctype>
#include <vector>
#include <sstream>

void read(const std::string &input, std::vector<std::string> &vectorString, std::vector<bool> &isRotated) {
    std::istringstream inputStream(input);
    std::string currentWord;
    while (inputStream >> currentWord) {
        char endChar = currentWord[currentWord.size() - 1];
        if (ispunct(endChar) && endChar != '-' && endChar != '+') {
            if (currentWord.size() > 1) {
                int wordSize = (int) currentWord.size();
                std::string firstWord;
                std::string secondWord;

                for (int i = wordSize - 1; i >= 0; --i) {
                    if (!ispunct(currentWord[i])) {
                        firstWord = currentWord.substr(0, i + 1);
                        secondWord = currentWord.substr(i + 1);
                        break;
                    }
                }

                vectorString.push_back(firstWord);
                isRotated.push_back(false);
                vectorString.push_back(secondWord);
                isRotated.push_back(true);
            } else {
                vectorString.push_back(currentWord);
                isRotated.push_back(true);
            }
        } else {
            vectorString.push_back(currentWord);
            isRotated.push_back(false);
        }
    }
}

void swapWords(std::vector<std::string> &vectorString, std::vector<bool> &isRotated, int leftIndex) {
    int rightIndex = (int) vectorString.size() - 1;

    while (rightIndex > leftIndex) {
        int leftWordSize = (int) vectorString[leftIndex].size();
        int rightWordSize = (int) vectorString[rightIndex].size();

        if (!isRotated[rightIndex] && leftWordSize == rightWordSize) {
            std::string leftWord = vectorString[leftIndex];
            std::string rightWord = vectorString[rightIndex];
            if (leftIndex == 0) {
                leftWord[0] = tolower(leftWord[0]);
                rightWord[0] = toupper(rightWord[0]);
            }

            vectorString[leftIndex] = rightWord;
            vectorString[rightIndex] = leftWord;

            isRotated[leftIndex] = true;
            isRotated[rightIndex] = true;
            break;
        }

        rightIndex--;
    }
}

void createTextFromVector(std::string &rotatedText, const std::vector<std::string> &vectorString) {
    std::ostringstream output;
    int size = (int) vectorString.size();

    for (int j = 0; j < size; ++j) {
        char currChar = vectorString[j][0];
        if (ispunct(currChar) && currChar != '-' && currChar != '+') {
            output << vectorString[j];
        } else {
            output << " " << vectorString[j];
        }
    }

    rotatedText = output.str();
    rotatedText = rotatedText.substr(1);
}

int main() {
    std::string input;
    getline(std::cin, input);

    std::vector<std::string> vectorString;
    std::vector<bool> isRotated;

    read(input, vectorString, isRotated);

    int vectorStringSize = (int) vectorString.size();
    for (int i = 0; i < vectorStringSize; ++i) {
        std::string leftWord = vectorString[i];

        if (ispunct(leftWord[0])) {
            continue;
        }

        if (isRotated[i]) {
            continue;
        }

        swapWords(vectorString, isRotated, i);
    }

    std::string rotatedText;

    createTextFromVector(rotatedText, vectorString);

    std::cout << rotatedText << std::endl;
    return 0;
}