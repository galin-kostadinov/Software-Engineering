#include <iostream>
#include <string>
#include <map>
#include <vector>

void print(std::map<std::string, int> &miners, std::vector<std::string> &appearanceOrder) {
    for (const std::string &resource:appearanceOrder) {
        int quantity = miners.find(resource)->second;

        std::cout << resource << " -> " << quantity << std::endl;
    }
}

int main() {
    std::map<std::string, int> miners;
    std::vector<std::string> appearanceOrder;

    std::string resource;
    int quantity;

    while (std::cin >> resource && resource != "stop" && std::cin >> quantity) {
        if (miners.find(resource) == miners.end()) {
            appearanceOrder.emplace_back(resource);
        }

        miners[resource] += quantity;
    }

    print(miners, appearanceOrder);

    return 0;
}