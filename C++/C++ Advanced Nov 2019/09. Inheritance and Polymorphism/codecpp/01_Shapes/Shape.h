#ifndef SHAPE_H
#define SHAPE_H

#include "Vector2D.h"

class Shape {
protected:
    Vector2D center;
    double area;

public:
    Shape(Vector2D center) : center(center), area(0) {}

    Shape() : center({0, 0}), area(0) {}

    Vector2D getCenter() const {
        return this->center;
    }

    double getArea() const {
        return this->area;
    }
};

#endif //!SHAPE_H
