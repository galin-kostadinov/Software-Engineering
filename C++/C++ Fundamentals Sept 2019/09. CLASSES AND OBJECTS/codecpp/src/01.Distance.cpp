#include <iostream>
#include <cmath>
#include <iomanip>

class Point {
private:
    double x;
    double y;

public:
    Point(double x, double y) : x(x), y(y) {
    }

    static double calcDistance(const Point &a, const Point &b) {
        return sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2));
    }
};

int main() {
    double x, y;

    std::cin >> x >> y;
    Point firstPoint(x, y);

    std::cin >> x >> y;
    Point secondPoint(x, y);

    std::cout << std::fixed << std::setprecision(3) << Point::calcDistance(firstPoint, secondPoint) << std::endl;

    return 0;
}