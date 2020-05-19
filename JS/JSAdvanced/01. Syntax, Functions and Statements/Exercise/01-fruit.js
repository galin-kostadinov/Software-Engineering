"use strict";

function solve(name, weight, price) {
    weight /= 1000;
    const totalPrice = weight * price;

    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${name}.`);
}

solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);