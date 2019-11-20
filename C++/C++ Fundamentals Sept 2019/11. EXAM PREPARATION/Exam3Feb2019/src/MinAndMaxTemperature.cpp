#include <iostream>
#include <map>

void read(std::map<std::string, std::pair<double, double>> &records, int townsNumber) {
    std::string town;
    double lower;
    double upper;

    std::map<std::string, std::pair<double, double>>::iterator it;

    while (townsNumber > records.size()) {
        getline(std::cin, town);
        std::cin >> lower >> upper;
        std::cin.ignore();

        if (lower > upper) {
            double temp = lower;
            lower = upper;
            upper = temp;
        }

        it = records.find(town);
        if (it == records.end()) {
            records[town] = std::make_pair(lower, upper);
        } else {
            if (lower < it->second.first) {
                it->second.first = lower;
            }

            if (upper > it->second.second) {
                it->second.second = upper;
            }
        }
    }
}

void print(std::map<std::string, std::pair<double, double>> &records) {
    std::map<std::string, std::pair<double, double>>::iterator it;

    for (it = records.begin(); it != records.end(); ++it) {
        std::cout << it->first << ' ' << it->second.first << ' ' << it->second.second << std::endl;
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int townsNumber;
    std::cin >> townsNumber;
    std::cin.ignore();

    std::map<std::string, std::pair<double, double>> records;

    read(records, townsNumber);

    print(records);

    return 0;
}
