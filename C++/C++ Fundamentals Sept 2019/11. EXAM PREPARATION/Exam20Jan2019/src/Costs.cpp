#include <iostream>

const double DAILY_ELECTRICAL_PRICE = 0.13;
const double NIGHT_ELECTRICAL_PRICE = 0.07;
const int NUMBER_OF_DAYS = 30;
const double WATER_COST_PER_CM3 = 1.65;
const double GAS_COST_PER_CM3 = 0.09;
const int MONEY_OF_CHILD = 40;

int main() {
    double water;
    double gas;
    double dailyEnergy;
    double rent;
    double nightEnergy;
    double motherSalary;
    double fatherSalary;

    std::cin >> water >> gas >> dailyEnergy >> rent >> nightEnergy >> motherSalary >> fatherSalary;

    double waterCosts = water * WATER_COST_PER_CM3;
    double gasCosts = gas * GAS_COST_PER_CM3;
    double electricalEnergyCosts = dailyEnergy * DAILY_ELECTRICAL_PRICE + nightEnergy * NIGHT_ELECTRICAL_PRICE;
    double allCosts = MONEY_OF_CHILD + waterCosts + gasCosts + electricalEnergyCosts + rent;
    double remainingSalary = motherSalary + fatherSalary - allCosts;
    double moneyForOneDay = remainingSalary / NUMBER_OF_DAYS;

    std::cout << "Water : " << waterCosts << std::endl;
    std::cout << "Gas : " << gasCosts << std::endl;
    std::cout << "Energy : " << electricalEnergyCosts << std::endl;
    std::cout << "All costs : " << allCosts << std::endl;
    std::cout << "Remaining Salary : " << remainingSalary << std::endl;

    if (remainingSalary < 0) {
        std::cout << "You should find new job !" << std::endl;
    }

    std::cout << "Money for one day : " << moneyForOneDay << std::endl;

    return 0;
}