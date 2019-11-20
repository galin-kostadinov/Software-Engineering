#include <iostream>
#include <string>
#include <map>

void calculate(std::map<std::string, double> &cityAmount, int citiesNumber) {
    std::string city;
    double price = 0;
    double quantity = 0;

    while (cityAmount.size() < citiesNumber) {
        std::cin >> city >> price >> quantity;

        cityAmount[city] += price * quantity;
    }
}

void printCitiesInfo(std::map<std::string, double> &cityAmount) {
    for (auto &kvp:cityAmount) {
        std::cout << kvp.first << ' ' << kvp.second << std::endl;
    }
}

int main() {
    std::map<std::string, double> cityAmount;
    int citiesNumber;
    std::cin >> citiesNumber;

    calculate(cityAmount, citiesNumber);
    printCitiesInfo(cityAmount);

    return 0;
}