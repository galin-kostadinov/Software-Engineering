"use strict";

function solve(arr) {
    return arr.filter((el, index) => index % 2 == 0).join(' ');
}

solve(['20', '30', '40']);