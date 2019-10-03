#include <iostream>
#include<string>
#include<sstream>

int main() {
    std::string line;
    getline(std::cin, line);
    std::istringstream lineStream(line);

    int sum = 0;

    std::ostringstream stream;
    std::string currWord;
    while (lineStream >> currWord) {
        if (!(isdigit(currWord[0]) || currWord[0] == '-')) {
            stream << currWord << " ";
        } else {
            sum += stoi(currWord);
        }
    }

    std::cout << sum << std::endl;
    std::cout << stream.str() << std::endl;

    return 0;
}