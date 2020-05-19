"use strict"

function solve(arr) {
    let x1 = arr[0];
    let y1 = arr[1];
    let x2 = arr[2];
    let y2 = arr[3];

    let dist1 = Math.sqrt(x1 ** 2 + y1 ** 2);

    if (Number.isInteger(dist1)) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`)
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`)
    }

    let dist2 = Math.sqrt(x2 ** 2 + y2 ** 2);
    if (Number.isInteger(dist2)) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`)
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`)
    }

    let dist3 = Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);
    if (Number.isInteger(dist3)) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`)
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`)
    }
}

solve([3, 0, 0, 4]);
solve([2, 1, 1, 1]);