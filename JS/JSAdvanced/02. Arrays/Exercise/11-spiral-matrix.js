"use strict";

function solve(rows, cols) {
    let matrix = Array(rows).fill().map(() => Array(cols).fill(0));

    const value = 1;
    spiral(value, 0, 0)

    function spiral(value, row, col) {
        if (!isInBound(row, col) || matrix[row][col] !== 0) {
            return;
        }

        matrix[row][col] = value;

        if (!isInBound(row - 1, col) || matrix[row - 1][col] !== 0) {
            spiral(value + 1, row, col + 1);
        }

        spiral(value + 1, row + 1, col);
        spiral(value + 1, row, col - 1);
        spiral(value + 1, row - 1, col);
    }

    function isInBound(row, col) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }

    console.log(matrix.map(r => r.join(' ')).join('\n'));;
}


function solve2(rows, cols) {
    function inRange(value, maxValue) {
        return 0 <= value && value < maxValue;
    }

    let rowDirs = [0, +1, 0, -1];
    let colDirs = [+1, 0, -1, 0];
    let dir = 0;
    let row = 0;
    let col = 0;
    let matrix = [];

    for (let i = 0; i < rows; ++i) {
        matrix[i] = new Array(cols).fill(null);
    }

    for (let i = 0; i < rows * cols; ++i) {
        matrix[row][col] = i + 1;
        let nextRow = row + rowDirs[dir];
        let nextCol = col + colDirs[dir];
        if (!inRange(nextRow, rows) || !inRange(nextCol, cols) || matrix[nextRow][nextCol]) {
            dir += 1;
            dir %= 4;
        }
        row += rowDirs[dir];
        col += colDirs[dir];
    }

    console.log(matrix.map(r => r.join(' ')).join('\n'));;
}

solve(5, 5);