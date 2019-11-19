#include <iostream>
#include <vector>
#include <string>
#include <sstream>

struct Point {
    std::string latitude;
    std::string longitude;
};

class Location {
public:
    std::string name;
    Point point;

    void printInfo() {
        std::cout << name << ','
                  << point.latitude << ','
                  << point.longitude << std::endl;
    }

    bool isAtSamePoint(const Point &point) {
        return (this->point.latitude == point.latitude) &&
               (this->point.longitude == point.longitude);
    }
};

class Atlas {
    std::vector<Location> _locations;

public:
    void parseLocationData(const std::string &input) {
        std::istringstream istr(input);

        Location currLocation;

        getline(istr, currLocation.name, ',');
        getline(istr, currLocation.point.latitude, ',');
        getline(istr, currLocation.point.longitude, ',');

        _locations.push_back(currLocation);
    }

    void executeQuery(const std::string &query) {
        for (Location &location : _locations) {
            if (location.name == query) {
                location.printInfo();
                break;
            }
        }
    }

    void executeQuery(const Point &point) {
        for (Location &location : _locations) {
            if (location.isAtSamePoint(point)) {
                location.printInfo();
            }
        }
    }
};


int main() {
    Atlas atlas;

    std::string input;

    while (getline(std::cin, input) && "." != input) {
        atlas.parseLocationData(input);
    }

    while (getline(std::cin, input) && !input.empty()) {
        std::istringstream testNumber(input);
        std::string latitude;
        std::string longitude;

        double isNumber;

        if (testNumber >> isNumber) {
            std::istringstream numberStream(input);

            numberStream >> latitude;
            numberStream >> longitude;

            Point point;
            point.latitude = latitude;
            point.longitude = longitude;

            atlas.executeQuery(point);
        } else {
            atlas.executeQuery(input);
        }
    }

    return 0;
}
