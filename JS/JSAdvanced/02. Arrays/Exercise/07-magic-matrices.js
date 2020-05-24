"use strict";

function solve(matrix) {
    let sum = 0;
    let isFirst = true;

    for (let row = 0; row < matrix.length; row++) {
        let currSum = 0;
        for (let col = 0; col < matrix[row].length; col++) {
            currSum += matrix[row][col];
        }

        if (isFirst) {
            sum = currSum;
        } else {
            if (currSum != sum) {
                return false;
            }
        }
    }

    for (let col = 0; col < matrix[0].length; col++) {
        let currSum = 0;
        for (let row = 0; row < matrix.length; row++) {
            currSum += matrix[row][col];
        }

        if (currSum != sum) {
            return false;
        }
    }

    return true;
}

 console.log(solve(
    [[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]])) ;

    console.log(solve(
    [[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]));