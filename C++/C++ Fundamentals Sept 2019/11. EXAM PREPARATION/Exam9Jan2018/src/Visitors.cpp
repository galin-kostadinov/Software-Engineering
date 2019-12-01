#include <iostream>
#include <unordered_map>
#include <string>
#include <sstream>
#include <utility>

int countVisitorsWithGivenName(const std::unordered_map<std::string, std::pair<std::string, int> > &data,
                               const std::string &name) {

    int count = 0;

    for (const auto &kvp:data) {
        if (kvp.second.first == name) {
            count++;
        }
    }

    return count;
}

int countVisitorsInGivenRange(std::unordered_map<std::string, std::pair<std::string, int> > &data,
                              int startAge, int endAge) {
    int count = 0;

    for (const auto &kvp:data) {
        if (kvp.second.second >= startAge && kvp.second.second < endAge) {
            count++;
        }
    }

    return count;
}

void commandInterpreter(std::unordered_map<std::string, std::pair<std::string, int> > &data) {

    std::string line;
    std::string command;
    std::string id;
    std::string name;
    int age;

    while (getline(std::cin, line) && line != "end") {
        std::istringstream iss(line);
        iss >> command;

        if (command == "entry") {
            iss >> id >> name >> age;

            if (data.find(id) == data.end()) {
                data.emplace(id, std::make_pair(name, age));
            }
        } else if (command == "name") {
            iss >> name;

            std::cout << countVisitorsWithGivenName(data, name) << std::endl;
        } else if (command == "age") {
            int startAge;
            int endAge;
            iss >> startAge >> endAge;

            std::cout << countVisitorsInGivenRange(data, startAge, endAge) << std::endl;
        }
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    std::unordered_map<std::string, std::pair<std::string, int> > data;

    commandInterpreter(data);

    return 0;
}