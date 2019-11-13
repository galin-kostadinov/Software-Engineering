#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

class Car {
    std::string make;
    int year;
    double price;

public:
    Car(std::string &make, int year, double price) : make(make), year(year), price(price) {}

    std::string getCarInfo() {
        std::ostringstream oss;
        oss << "Make : " << this->getMake() << std::endl;
        oss << "Year : " << this->getYear() << std::endl;
        oss << "Price : " << this->getPrice();

        return oss.str();
    }

    const std::string &getMake() const {
        return make;
    }

    int getYear() const {
        return year;
    }

    double getPrice() const {
        return price;
    }
};

class AutoHouse {
    const double INITIAL_CAPITAL = 10000;
    const double OVERCHARGE_TAX = 500;
    double capital;
    double overchargeTax;
    std::vector<Car> cars;

public:
    AutoHouse(double capital, double overchargeTax) {
        this->setCapital(capital);
        this->setOverchargeTax(overchargeTax);
    }


    void setCapital(double capital) {
        if (capital <= 0) {
            this->capital = INITIAL_CAPITAL;
        } else {
            this->capital = capital;
        }
    }

    double getCapital() const {
        return capital;
    }

    void setOverchargeTax(double overchargeTax) {
        if (capital <= 0) {
            this->overchargeTax = OVERCHARGE_TAX;
        } else {
            this->overchargeTax = overchargeTax;
        }
    }

    std::string showAllCars() {
        std::ostringstream oss;

        for (Car &car:this->cars) {
            oss << car.getCarInfo() << std::endl;
        }

        return oss.str();
    }

    void buyACar(Car car) {
        if (this->capital >= car.getPrice()) {
            cars.emplace_back(car);
            this->capital -= car.getPrice();
        }
    }

    void sellAllCars() {
        for (Car &car:this->cars) {
            this->capital += car.getPrice() + overchargeTax;
        }
        cars.clear();
    }
};

void readCommands(std::vector<int> &commands) {
    int command;
    while (std::cin >> command && command != 0) {
        commands.emplace_back(command);
    }
}

void commandInterpreter(AutoHouse &autoHouse, std::vector<int> &commands) {
    int currCommand = 0;
    int previousInput = 0;
    std::string make;
    int year = 0;
    double price = 0;
    int commandCount = commands.size();

    for (int i = 0; i < commandCount; ++i) {
        currCommand = commands[i];

        switch (currCommand) {
            break;
            case 1:
                if (previousInput == 3) {
                    std::cout << autoHouse.showAllCars();
                }
                break;
            case 2:
                if (previousInput == 3) {
                    std::cout << "Capital before sell : " << autoHouse.getCapital() << std::endl;
                    autoHouse.sellAllCars();
                    std::cout << "Capital after sell : " << autoHouse.getCapital() << std::endl;
                    previousInput = 2;
                }
                break;
            case 3:
                std::cin >> make >> year >> price;
                autoHouse.buyACar(Car(make, year, price));
                previousInput = 3;
                break;
        }
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    double capital, overchargeTax;
    std::cin >> capital >> overchargeTax;

    AutoHouse autoHouse(capital, overchargeTax);

    std::vector<int> commands;
    readCommands(commands);

    std::sort(commands.begin(), commands.end(), std::greater<int>());

    commandInterpreter(autoHouse, commands);

    return 0;
}