#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>

int convertStringToHex(const std::string &hexNumAsString) {
    return stoi(hexNumAsString, nullptr, 16);
}

int main() {
    std::string firstColor;
    std::string secondColor;
    std::cin >> firstColor >> secondColor;
    firstColor = firstColor.substr(1);
    secondColor = secondColor.substr(1);

    std::ostringstream output;
    output << "#";

    for (int i = 0; i < 6; i += 2) {
        std::string currentPartFirstColor = firstColor.substr(i, 2);
        std::string currentPartSecondColor = secondColor.substr(i, 2);

        int currResult = (convertStringToHex(currentPartFirstColor) + convertStringToHex(currentPartSecondColor)) / 2;
        output << std::setfill('0') << std::setw(2) << std::hex << currResult;
    }

    std::cout << output.str() << std::endl;
    return 0;
}