#include<iostream>
#include <sstream>
#include <string>
#include <vector>
#include <fstream>

class AstronomicalObject {
    std::string homeName;
    int position;
    double mass;
    double radius;
    std::string type;
    std::string nickname;

public:
    AstronomicalObject(std::string &homeName, int position, double mass, double radius, std::string &type,
                       std::string &nickname) : homeName(homeName), position(position), mass(mass), radius(radius),
                                           type(type), nickname(nickname) {
        setPosition(type);
    }

    AstronomicalObject(std::string &homeName, int position, double mass, double radius, std::string &type) :
            homeName(homeName), position(position), mass(mass), radius(radius), type(type), nickname("unknown") {
        setPosition(type);
    }

    const std::string &getHomeName() const {
        return homeName;
    }

    int getPosition() const {
        return position;
    }

    bool setType(const std::string &type) {
        if (this->type == "unknown") {
            this->type = type;
            return true;
        }

        return false;
    }

    void setHomeName(const std::string &homeName) {
        this->homeName = homeName;
    }

    const std::string getOutputForFile() const {
        std::ostringstream oss;
        oss << this->homeName << ';'
            << this->position << ';'
            << this->mass << ';'
            << this->radius << ';'
            << this->type << ';'
            << this->nickname << ';';

        return oss.str();
    }

    const std::string getInfo() const {
        std::ostringstream oss;
        oss << this->homeName << "-" << this->position;

        if (this->nickname != "unknown") {
            oss << " (" << this->nickname << ")";
        }

        oss << " { mass: " << this->mass << ", radius: " << this->radius << "}";

        return oss.str();
    }

private:
    void setPosition(std::string &type) {
        if (type == "star" && this->position != 1) {
            this->position = 1;
        }
    }
};

void createObject(std::vector<AstronomicalObject> &objectsList, const std::string &line);

void printAllPlanets(std::vector<AstronomicalObject> &objectsList, const std::string &line);

void printPlanet(const std::vector<AstronomicalObject> &objectsList, const std::string &line);

void writeInFile(const std::vector<AstronomicalObject> &objectsList);

void readFromFile(std::vector<AstronomicalObject> &objectsList);

std::string changeHomeName(std::vector<AstronomicalObject> &objectsList, const std::string &parameters);

std::string changeType(std::vector<AstronomicalObject> &objectsList, const std::string &parameters);

void readParameters(std::istringstream &iss, std::string &homeName, int &position);

void readParameters(std::istringstream &iss, std::string &homeName, int &position, std::string &newString);

int main() {
    std::vector<AstronomicalObject> objectsList;

    readFromFile(objectsList);

    std::string command;
    std::string commandLine;

    while (getline(std::cin, commandLine) && commandLine != "end") {
        int endIndex = commandLine.find(';') != -1 ? commandLine.find(';') : commandLine.size();

        command = commandLine.substr(0, endIndex);
        std::string parameters = commandLine.substr(endIndex + 1);

        if (command == "create") {
            createObject(objectsList, parameters);
        } else if (command == "getAllPlanets") {
            printAllPlanets(objectsList, parameters);
        } else if (command == "getPlanet") {
            printPlanet(objectsList, parameters);
        } else if (command == "changeHomeName") {
            std::cout << changeHomeName(objectsList, parameters) << std::endl;
        } else if (command == "changeType") {
            std::cout << changeType(objectsList, parameters) << std::endl;
        }
    }

    writeInFile(objectsList);

    return 0;
}

void createObject(std::vector<AstronomicalObject> &objectsList, const std::string &line) {
    std::istringstream iss(line);

    std::string homeName;
    int position = 0;
    double mass = 0;
    double radius = 0;
    std::string type;
    std::string nickname = "unknown";

    std::string positionAsString;
    std::string massAsString;
    std::string radiusAsString;

    getline(iss, homeName, ';');
    getline(iss, positionAsString, ';');
    getline(iss, massAsString, ';');
    getline(iss, radiusAsString, ';');
    getline(iss, type, ';');
    getline(iss, nickname, ';');

    position = stoi(positionAsString);
    mass = stod(massAsString);
    radius = stod(radiusAsString);

    objectsList.emplace_back(AstronomicalObject(homeName, position, mass, radius, type, nickname));
}

void printAllPlanets(std::vector<AstronomicalObject> &objectsList, const std::string &line) {
    std::istringstream iss(line);

    std::string homeName;
    getline(iss, homeName, ';');

    for (const AstronomicalObject &object:objectsList) {
        if (object.getHomeName() == homeName) {
            std::cout << object.getInfo() << std::endl;
        }
    }
}

void printPlanet(const std::vector<AstronomicalObject> &objectsList, const std::string &line) {
    std::istringstream iss(line);

    std::string homeName;
    int position;

    readParameters(iss, homeName, position);

    for (const AstronomicalObject &object:objectsList) {
        if (object.getHomeName() == homeName && object.getPosition() == position) {
            std::cout << object.getInfo() << std::endl;
            break;
        }
    }
}

void writeInFile(const std::vector<AstronomicalObject> &objectsList) {

    try {
        std::ofstream ofs("solar_system.txt");
        if (ofs.is_open()) {
            for (const AstronomicalObject &object:objectsList) {
                ofs << object.getOutputForFile() << std::endl;
            }

            ofs.close();
        }
    } catch (std::exception &ex) {
        std::cout << "Error: File is read-only" << std::endl;

        std::ofstream ofs("solar_system_ERROR.txt");
        if (ofs.is_open()) {
            for (const AstronomicalObject &object:objectsList) {
                ofs << object.getOutputForFile() << std::endl;
            }

            ofs.close();
        }

        std::cout << "Was created new fail: \"solar_system_ERROR.txt\"" << std::endl;
    }
}

void readFromFile(std::vector<AstronomicalObject> &objectsList) {
    std::string line;

    try {
        std::ifstream ifs("solar_system.txt");
        if (ifs.is_open()) {
            while (getline(ifs, line)) {
                createObject(objectsList, line);
            }

            ifs.close();
        }else{
            std::cout << "Error: File is not found" << std::endl;
        }
    } catch (std::exception &ex) {
        std::cout << "Error: File is not found" << std::endl;
    }
}

std::string changeHomeName(std::vector<AstronomicalObject> &objectsList, const std::string &parameters) {
    std::istringstream iss(parameters);

    std::string homeName;
    int position;
    std::string newHomeName;
    readParameters(iss, homeName, position, newHomeName);

    std::string message = "Astronomical Object was not found!";

    for (AstronomicalObject &object:objectsList) {
        if (object.getHomeName() == homeName && object.getPosition() == position) {
            object.setHomeName(newHomeName);
            message.clear();
            message.append("Home name was changed successful from ")
                    .append(homeName).append(" to ").append(newHomeName).append("!");
            break;
        }
    }

    return message;
}

std::string changeType(std::vector<AstronomicalObject> &objectsList, const std::string &parameters) {
    std::istringstream iss(parameters);
    std::string homeName;
    int position;
    std::string newType;

    readParameters(iss, homeName, position, newType);

    std::string message = "Astronomical Object was not found!";

    for (AstronomicalObject &object:objectsList) {
        if (object.getHomeName() == homeName && object.getPosition() == position) {
            if (object.setType(newType)) {
                message.clear();
                message.append("Type was changed successful from unknown to ").append(newType).append("!");
            }else{
                message.clear();
                message.append("Current type is immutable!");
            }

            break;
        }
    }

    return message;
}

void readParameters(std::istringstream &iss, std::string &homeName, int &position) {
    std::string positionAsString;

    getline(iss, homeName, ';');
    getline(iss, positionAsString, ';');

    position = stoi(positionAsString);
}

void readParameters(std::istringstream &iss, std::string &homeName, int &position, std::string &newString) {
    readParameters(iss, homeName, position);

    getline(iss, newString, ';');
}