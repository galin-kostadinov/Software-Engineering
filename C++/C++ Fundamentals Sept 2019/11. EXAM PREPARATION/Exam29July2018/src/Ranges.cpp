#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

void readRanges(std::vector<int> &ranges) {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int from, to;
    while (std::cin >> from >> to) {
        ranges.emplace_back(from);
        ranges.emplace_back(to);
    }

    std::cin.clear();
    char dot;
    std::cin >> dot;
}

void foundNumber(std::vector<int> &ranges) {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::ostringstream oss;
    int number;
    std::vector<int>::iterator itLow;
    while (std::cin >> number) {
        itLow = std::lower_bound(ranges.begin(), ranges.end(), number);

        if (itLow == ranges.end()) {
            oss << "out" << std::endl;
            continue;
        }

        if (*itLow == number) {
            oss << "in" << std::endl;
            continue;
        }

        if (std::distance(ranges.begin(), itLow) & 1) {
            oss << "in" << std::endl;
        } else {
            oss << "out" << std::endl;
        }
    }

    std::cin.clear();
    char dot;
    std::cin >> dot;

    std::cout << oss.str();
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::vector<int> ranges;

    readRanges(ranges);

    std::sort(ranges.begin(), ranges.end());

    foundNumber(ranges);

    return 0;
}