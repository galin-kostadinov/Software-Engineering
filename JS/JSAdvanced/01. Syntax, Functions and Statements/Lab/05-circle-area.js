"use strict";

function solve(arg) {
    const typeOfArg = typeof arg;

    let result;
    if (typeOfArg === "number") {
        result = (Math.PI * (arg ** 2)).toFixed(2);
    } else {
        result = `We can not calculate the circle area, because we receive a ${typeOfArg}.`
    }

    console.log(result);
}

solve('name');