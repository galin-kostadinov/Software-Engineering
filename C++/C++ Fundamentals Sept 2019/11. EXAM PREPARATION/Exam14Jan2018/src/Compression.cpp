#include <iostream>
#include <vector>
#include <string>

void makeDecompression(std::vector<std::pair<int, char>> &decompressChars) {
    std::string text;
    std::cin >> text;

    std::string countAsString;

    int size = (int) text.size();
    for (int i = 0; i < size; ++i) {
        char currChar = text[i];

        if (isdigit(currChar)) {
            countAsString.push_back(currChar);
        } else {
            if (countAsString.empty()) {
                decompressChars.emplace_back(1, currChar);
            } else {
                int count = stoi(countAsString);
                countAsString.clear();

                decompressChars.emplace_back(count, currChar);
            }
        }
    }
}

void print(std::vector<std::pair<int, char>> &decompressChars) {
    char currChar;
    int count;

    int size = (int) decompressChars.size();

    for (int j = 0; j < size; ++j) {
        count = decompressChars[j].first;
        currChar = decompressChars[j].second;

        for (int i = 0; i < count; ++i) {
            std::cout << currChar;
        }
    }

    std::cout << std::endl;
}

int main() {
    std::vector<std::pair<int, char>> decompressChars;

    makeDecompression(decompressChars);
    print(decompressChars);

    return 0;
}