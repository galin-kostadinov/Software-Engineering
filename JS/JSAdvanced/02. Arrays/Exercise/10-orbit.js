"use strict";

function solve(arr) {
    const width = arr[0];
    const height = arr[1];
    const rowStart = arr[2];
    const colStart = arr[3];

    let matrix = Array(height).fill().map(() => Array(width).fill());


    for (let row = 0; row < height; row++) {
        for (let col = 0; col < width; col++) {
            matrix[row][col] = Math.max(Math.abs(row - rowStart), Math.abs(col - colStart)) + 1;
        }
    }

    console.log(matrix.map(row => row.join(' ')).join('\n'));
}

// solve([5, 5, 2, 2]);

solve([4, 4, 0, 0]);