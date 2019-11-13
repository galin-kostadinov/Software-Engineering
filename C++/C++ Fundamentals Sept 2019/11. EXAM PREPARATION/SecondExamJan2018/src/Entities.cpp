#include <iostream>
#include <sstream>
#include <vector>
#include <map>

using namespace std;

void createDataColumns(std::vector<std::string> &colNames, std::map<std::string, std::vector<string>> &data) {
    std::string line;
    std::getline(std::cin, line);

    istringstream iss(line);
    std::string field;

    while (iss >> field) {
        colNames.emplace_back(field);
        std::vector<string> elements;
        data[field] = elements;
    }
}

void readDataElements(const std::vector<std::string> &colNames, std::map<std::string, std::vector<string>> &data) {
    std::string line;
    std::string element;

    while (std::getline(std::cin, line) && line != "end") {
        istringstream iss(line);

        int col = 0;

        while (iss >> element) {
            std::string field = colNames[col++];
            data[field].emplace_back(element);
        }
    }
}

void foundMostCommonValueForField(const std::map<std::string, std::vector<string>> &data, const std::string &field) {
    const map<string, vector<string>>::const_iterator &it = data.find(field);
    std::vector<string> elements = it->second;

    map<string, int> elementsCount;

    int size = (int) elements.size();
    for (int i = 0; i < size; ++i) {
        ++elementsCount[it->second[i]];
    }

    int count = 0;
    string element;
    for (const auto kvp : elementsCount) {
        if (kvp.second > count) {
            count = kvp.second;
            element = kvp.first;
        }
    }

    std::cout << element << ' ' << count << std::endl;
}

int main() {
    std::vector<std::string> colNames;
    std::map<std::string, std::vector<string>> data;

    createDataColumns(colNames, data);
    readDataElements(colNames, data);

    std::string field;
    std::getline(std::cin, field);

    foundMostCommonValueForField(data, field);

    return 0;
}