#include <iostream>
#include <string>
#include <vector>

const int LIGHT_SPEED = 299792;

class Planet {
    std::string name;
    int distance;
    int diameter;
    int mass;
public:
    Planet(std::string &name, int distance, int diameter, int mass) : name(name), distance(distance),
                                                                      diameter(diameter), mass(mass) {}

    int getDiameter() const {
        return diameter;
    }

    int getMass() const {
        return mass;
    }

    int calculateSecondsToSun() const {
        return this->distance / LIGHT_SPEED;
    }

    void print() const {
        std::cout << this->name << ' ' << this->distance << ' ' << this->diameter
                  << ' ' << this->mass << std::endl << this->calculateSecondsToSun() << std::endl;
    }
};

void readPlanet(std::vector<Planet> &planets) {
    std::string name;
    int distance;
    int diameter;
    int mass;
    std::cin >> name >> distance >> diameter >> mass;

    planets.emplace_back(Planet(name, distance, diameter, mass));
}

int calculateMinMass(const std::vector<Planet> &planets, const int planetNumber) {
    int mass = INT32_MAX;

    for (int i = 0; i < planetNumber; ++i) {
        if (planets[i].getMass() < mass) {
            mass = planets[i].getMass();
        }
    }

    return mass;
}

int calculateMaxDiameter(const std::vector<Planet> &planets, const int planetNumber) {
    int diameter = 0;

    for (int i = 0; i < planetNumber; ++i) {
        if (planets[i].getDiameter() > diameter) {
            diameter = planets[i].getDiameter();
        }
    }

    return diameter;
}

void printPlanetsInfo(const std::vector<Planet> &planets, const int planetNumber) {
    for (int i = 0; i < planetNumber; ++i) {
        planets[i].print();
    }
}

int main() {
    int planetNumber;
    std::cin >> planetNumber;

    std::vector<Planet> planets;

    for (int i = 0; i < planetNumber; ++i) {
        readPlanet(planets);
    }

    printPlanetsInfo(planets, planetNumber);

    std::cout << calculateMinMass(planets, planetNumber) << std::endl;
    std::cout << calculateMaxDiameter(planets, planetNumber);

    return 0;
}