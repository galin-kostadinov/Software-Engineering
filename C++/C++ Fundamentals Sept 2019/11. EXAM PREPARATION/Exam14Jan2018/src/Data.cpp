#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <utility>

typedef std::vector<std::vector<std::pair<std::string, std::string>>> kvp;

void readData(kvp &data) {
    std::string line;

    while (std::getline(std::cin, line) && line != "[queries]") {
        std::istringstream iss(line);
        std::string name;

        std::vector<std::pair<std::string, std::string>> field;

        while (iss >> name) {
            std::string value;
            iss >> value;
            field.emplace_back(name, value);
        }

        data.emplace_back(field);
    }
}

void queriesByValue(kvp &data, std::vector<int> &indexes, std::string &value) {
    int sizeData = (int) data.size();

    for (int i = 0; i < sizeData; ++i) {
        int sizeField = (int) data[i].size();

        for (int j = 0; j < sizeField; ++j) {
            if (data[i][j].second == value) {
                indexes.emplace_back(i);
                break;
            }
        }
    }
}

void queriesByName(kvp &data, std::vector<int> &indexes, std::vector<std::string> &result, std::string &name) {
    for (size_t i = 0; i < indexes.size(); ++i) {
        for (size_t j = 0; j < data[indexes[i]].size(); ++j) {
            if (data[indexes[i]][j].first == name) {
                if (data[indexes[i]][j].second != "") {
                    result.emplace_back(data[indexes[i]][j].second);
                }
            }
        }
    }
}

void queries(kvp &data) {
    std::string value;
    std::string name;

    std::vector<std::string> result;
    std::vector<int> indexes;

    while (std::cin >> value && value != "end") {
        std::cin >> name;

        queriesByValue(data, indexes, value);
        if (!indexes.empty()) {
            queriesByName(data, indexes, result, name);

            for (const std::string &text  : result) {
                std::cout << text << ' ';
            }

            indexes.clear();
            result.clear();
        } else {
            std::cout << "[not found]";
        }

        std::cout << std::endl;
    }
}

int main() {
    kvp data;

    readData(data);
    queries(data);

    return 0;
}