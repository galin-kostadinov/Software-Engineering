"use strict"

function solve(arr) {
    return arr.flat().map(el => Number(el)).reduce((max, el) => el > max ? max = el : max, Number.NEGATIVE_INFINITY);
}

console.log(solve(
    [])
);

console.log(solve(
    [[20, 50, 10],
    [8, 33, 145]])
);

console.log(solve(
    [[3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]])
);