"use strict";

function solve(arr) {
    let x1 = arr[0];
    let y1 = arr[1];
    let x2 = arr[2];
    let y2 = arr[3];

    isValid(x1, y1, 0, 0);
    isValid(x2, y2, 0, 0);
    isValid(x1, y1, x2, y2);

    function isValid(x1, y1, x2, y2) {
        let dist = Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);

        const valid = Number.isInteger(dist) ? 'valid' : 'invalid';
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${valid}`)
    }
}

solve([3, 0, 0, 4]);
solve([2, 1, 1, 1]);