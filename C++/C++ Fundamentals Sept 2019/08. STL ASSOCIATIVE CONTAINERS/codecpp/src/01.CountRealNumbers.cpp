#include <iostream>
#include <sstream>
#include <map>

int main() {
    std::string line;
    std::getline(std::cin, line);

    std::map<double, int> numbersCount;
    std::istringstream stream(line);

    double currNum;

    while (stream >> currNum) {
        numbersCount[currNum]++;
    }

    for (std::pair<double, int> kvp: numbersCount) {
        std::cout << kvp.first << " -> " << kvp.second << std::endl;
    }

    return 0;
}