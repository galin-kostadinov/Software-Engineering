"use strict";

function solve(arr) {
    const first = +arr[0];
    const last = +arr[arr.length - 1];
    return first + last;
}

solve(['20', '30', '40']);