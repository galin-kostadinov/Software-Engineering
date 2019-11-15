#include <iostream>

class Rectangle {
private:
    double firstSide;
    double secondSide;

public:
    Rectangle(double firstSide, double secondSide) : firstSide(firstSide), secondSide(secondSide) {
    }

    double area() {
        return this->firstSide * this->secondSide;
    }

    double perimeter() {
        return 2 * this->firstSide + 2 * this->secondSide;
    }

};

int main() {
    double firstSide, secondSide;

    std::cin >> firstSide >> secondSide;
    Rectangle rectangle(firstSide, secondSide);

    std::cout << rectangle.area() << std::endl;
    std::cout << rectangle.perimeter() << std::endl;

    return 0;
}