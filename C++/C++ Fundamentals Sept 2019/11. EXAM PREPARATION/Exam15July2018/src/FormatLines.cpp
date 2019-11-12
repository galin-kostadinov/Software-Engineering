#include <iostream>
#include <deque>

void read(std::deque<std::string> &words) {
    std::string word;
    while (std::cin >> word && word != "###") {
        words.emplace_back(word);
    }
}

void print(std::deque<std::string> &allWords, int maxLength) {
    std::string print;
    int currLength = 0;

    while (!allWords.empty()) {
        std::string word = allWords.front();
        allWords.pop_front();

        if (print.empty()) {
            print.append(word);

            if (print.size() >= maxLength) {
                std::cout << print << std::endl;
                print.clear();
            }
            continue;
        }

        if (print.size() >= maxLength || print.size() + 1 + word.size() > maxLength) {
            std::cout << print << std::endl;
            print.clear();
            print.append(word);
        } else if (print.size() + 1 + word.size() == maxLength) {
            std::cout << print << ' ' << word << std::endl;
            print.clear();
        } else if (print.size() + 1 + word.size() < maxLength) {
            print.append(" ").append(word);
        }
    }

    if (!print.empty()) {
        std::cout << print << std::endl;
    }
}

int main() {
    std::deque<std::string> allWords;

    read(allWords);

    int maxLength;
    std::cin >> maxLength;

    print(allWords, maxLength);

    return 0;
}