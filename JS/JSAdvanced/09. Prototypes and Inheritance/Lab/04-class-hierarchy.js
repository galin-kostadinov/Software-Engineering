"use strict";

function factory() {
    class Figure {
        constructor(unit = 'cm') {
            this.unit = unit;
        }

        changeUnits(toUnit) {
            this.unit = toUnit;
        }

        get _unitCoefficient() {
            if (this.unit === 'cm') {
                return 1;
            } else if (this.unit === 'mm') {
                return 10;
            } else if (this.unit === 'm') {
                return 0.1;
            }
        }
    }

    class Circle extends Figure {
        constructor(radius, unit) {
            super(unit);
            this.radius = radius;
        }

        get area() {
            return Math.PI * this.radius * this.radius * (this._unitCoefficient ** 2);
        }

        toString() {
            return `Figures units: ${this.unit} Area: ${this.area} - radius: ${this._unitCoefficient * this.radius}`;
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, unit) {
            super(unit);
            this.width = width;
            this.height = height;
        }

        get area() {
            return this.width * this.height * (this._unitCoefficient ** 2);
        }

        toString() {
            return `Figures units: ${this.unit} Area: ${this.area} - width: ${this._unitCoefficient * this.width}, height: ${this._unitCoefficient * this.height}`;
        }
    }

    return {
        Figure,
        Circle,
        Rectangle
    }
}

let obj = factory();


let c = new obj.Circle(5);
console.log(c.area); // 78.53981633974483
console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5

let r = new obj.Rectangle(3, 4, 'mm');
console.log(r.area); // 1200 
console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40

r.changeUnits('cm');
console.log(r.area); // 12
console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4

c.changeUnits('mm');
console.log(c.area); // 7853.981633974483
console.log(c.toString()) // Figures units: mm Area: 7853.981633974483 - radius: 50