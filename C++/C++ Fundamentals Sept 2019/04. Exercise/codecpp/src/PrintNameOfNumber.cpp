#include <iostream>
#include <vector>
#include <string>

using namespace std;

void printArray(const std::vector<string> &array) {
    for (const auto & i : array) {
        std::cout << i << " ";
    }

    std::cout << std::endl;
}

void addThousandsAsText(vector<string> &numberAsText, int thousands);

void addHundredsAsText(vector<string> &numberAsText, int hundreds);

void addDozensAsText(vector<string> &numberAsText, int dozens, int units);

void addUnitsAsText(vector<string> &numberAsText, int units);

int main() {
    int number;
    cin >> number;

    int thousands = number / 1000;
    int hundreds = (number - thousands * 1000) / 100;
    int dozens = (number - thousands * 1000 - hundreds * 100) / 10;
    int units = number % 10;

    vector<string> numberAsText;

    if (number == 0) {
        cout << "zero" << endl;
        return 0;
    }

    if (thousands != 0) {
        addThousandsAsText(numberAsText, thousands);
    }

    if (hundreds != 0) {
        addHundredsAsText(numberAsText, hundreds);
    }

    if (dozens != 0) {
        addDozensAsText(numberAsText, dozens, units);
    }

    if (units != 0 && dozens != 1) {
        addUnitsAsText(numberAsText, units);
    }

    printArray(numberAsText);

    return 0;
}

void addThousandsAsText(vector<string> &numberAsText, int thousands) {
    addUnitsAsText(numberAsText, thousands);
    numberAsText.emplace_back("thousand");
}

void addHundredsAsText(vector<string> &numberAsText, int hundreds) {
    addUnitsAsText(numberAsText, hundreds);
    numberAsText.emplace_back("hundred");
}

void addDozensAsText(vector<string> &numberAsText, int dozens, int units) {
    string nums10to19[10]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                          "eighteen", "nineteen"};

    string nums20to90[8]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    if (dozens == 1) {
        numberAsText.push_back(nums10to19[units]);
    } else {
        numberAsText.push_back(nums20to90[dozens-2]);
    }
}

void addUnitsAsText(vector<string> &numberAsText, int units) {
    string numbersAsText[9]{"one", "two", "three", "tour", "five", "six", "seven", "eight", "nine"};
    numberAsText.push_back(numbersAsText[units - 1]);
}