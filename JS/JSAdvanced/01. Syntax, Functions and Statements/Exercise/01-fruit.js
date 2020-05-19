"use strict";

function solve(name, weightInGrams, price) {
    const weightInKilos = weightInGrams / 1000;
    const totalPrice = weightInKilos * price;

    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKilos.toFixed(2)} kilograms ${name}.`);
}

solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);