"use strict";

function solve(name, age, weight, height) {
    const BMI = Math.round(weight / ((height / 100) ** 2));
    const status = checkStatus();
    const info = {
        name: name,
        personalInfo: {
            age: age,
            weight: weight,
            height: height
        },
        BMI: BMI,
        status: status,
    };

    function checkStatus() {
        if (BMI < 18.5) {
            return 'underweight';
        } else if (BMI < 25) {
            return 'normal';
        } else if (BMI < 30) {
            return 'overweight';
        } else {
            return 'obese';
        }
    }

    if (info.status === 'obese') {
        info.recommendation = 'admission required';
    }

    return info;
}

console.log(solve("Peter", 29, 75, 182));
console.log(solve("Honey Boo Boo", 9, 57, 137));