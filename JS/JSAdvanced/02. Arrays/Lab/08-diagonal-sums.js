"use strict"

function solve(arr) {
    let index = 0;
    const mainDiagonal = arr.reduce((sum, row) => sum += row[index++], 0);

    index -= 1;

    const secondaryDiagonal = arr.reduce((sum, row) => sum += row[index--], 0);

    console.log(mainDiagonal + ' ' + secondaryDiagonal);
}

solve(
    [[20, 40],
    [10, 60]]);

solve(
    [[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]);