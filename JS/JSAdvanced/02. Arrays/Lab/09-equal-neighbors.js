"use strict"

function solve(matrix) {
    const count = matrix.reduce((acc, currRow, rowIndex) => {
        let currCount = currRow.reduce((acc2, currItem, itemIndex) => {
            if (currItem === currRow[itemIndex + 1]) {
                acc2++;
            }
            if (currItem === (matrix[rowIndex + 1] || [])[itemIndex]) {
                acc2++;
            }
            return acc2;
        }, 0);
        return acc + currCount;
    }, 0);

    console.log(count);
}

solve(
    [['2', '3', '4', '7', '0'],
    ['4', '0', '5', '3', '4'],
    ['2', '3', '5', '4', '2'],
    ['9', '8', '7', '5', '4']]);

solve(
    [['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']]
);