"use strict";

function solve(matrix) {
    matrix = matrix.map(row => row.split(' ').map(el => Number(el)));

    let sumLeftDiagonal = 0;
    let sumRightDiagonal = 0;
    let firstIndex = 0;
    let secondIndex = matrix.length - 1;

    matrix.forEach(row => {
        sumLeftDiagonal += row[firstIndex++];
        sumRightDiagonal += row[secondIndex--];
    });

    const matrixSize = matrix.length;

    if (sumLeftDiagonal === sumRightDiagonal) {
        for (let row = 0; row < matrixSize; row++) {
            for (let col = 0; col < matrixSize; col++) {
                if (row - col === 0 || row + col ===matrixSize-1){
                    continue;
                }
               
                matrix[row][col] = sumLeftDiagonal;
           }
        }
    }

    for (let row of matrix) {
        console.log(row.join(' '));
    }
}

solve(
    ['5 3 12 3 1',
        '11 4 23 2 5',
        '101 12 3 21 10',
        '1 4 5 2 2',
        '5 22 33 11 1']
);

solve(
    ['1 1 1',
    '1 1 1',
    '1 1 0']
);