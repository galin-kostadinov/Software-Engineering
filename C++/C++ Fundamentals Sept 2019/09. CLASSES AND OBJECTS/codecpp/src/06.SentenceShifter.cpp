#include <iostream>
#include <string>
#include <sstream>
#include <deque>

class Shifter {
    std::string text;
    std::deque<std::string> words;

public:
    Shifter(std::string text) : text(text) {
        this->fillDeque();
    }

    std::deque<std::string> getShiftedSentence(int shiftNumber) {
        std::ostringstream oss;

        if (words.size() > 0) {
            shiftNumber = shiftNumber % words.size();

            while (shiftNumber-- > 0) {
                words.push_front(words.back());
                words.pop_back();
            }
        }

        return this->words;
    }

private:
    void fillDeque() {
        std::istringstream iss(this->text);

        std::string word;
        while (iss >> word) {
            this->words.emplace_back(word);
        }
    }
};

int main() {
    std::string line;
    getline(std::cin, line);

    Shifter text(line);

    int shiftNumber;
    std::cin >> shiftNumber;

    std::deque<std::string> words = text.getShiftedSentence(shiftNumber);

    while (!words.empty()) {
        std::cout << words.front() << std::endl;
        words.pop_front();
    }

    return 0;
}