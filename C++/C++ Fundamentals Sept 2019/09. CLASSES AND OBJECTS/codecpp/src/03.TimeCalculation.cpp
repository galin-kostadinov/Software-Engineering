#include <iostream>

class TimeCalculator {
    const int MINUTES_IN_HOUR = 60;
    const int SECONDS_IN_MINUTE = 60;

private:
    int hours;
    int minutes;
    int second;

public:
    TimeCalculator(int hours, int minutes, int second) {
        this->calculateSecond(hours, minutes, second);
        this->calculateMinutes();
        this->calculateHour();
    }

    int getHours() {
        return this->hours;
    }

    int getMinutes() {
        return this->minutes;
    }

    int getSeconds() {
        return this->second;
    }

private:
    int calculateHour() {
        this->hours = this->minutes / MINUTES_IN_HOUR;
    }

    int calculateMinutes() {
        this->minutes = this->second / SECONDS_IN_MINUTE;
    }

    int calculateSecond(int hours, int minutes, int second) {
        this->second = (hours * MINUTES_IN_HOUR + minutes) * SECONDS_IN_MINUTE + second;
    }
};

int main() {
    int hours, minutes, second;

    std::cin >> hours >> minutes >> second;

    TimeCalculator time{hours, minutes, second};

    std::cout << time.getHours() << std::endl;
    std::cout << time.getMinutes() << std::endl;
    std::cout << time.getSeconds() << std::endl;

    return 0;
}