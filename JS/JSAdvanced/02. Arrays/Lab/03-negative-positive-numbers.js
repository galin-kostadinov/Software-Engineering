"use strict";

function solve(arr) {
    return arr.sort(sortByValue).forEach(element => {
        console.log(element);
    });

    function sortByValue(a, b) {
        if (a == 0) {
            return 1;
        }

        if (a < 0) {
            return -1;
        }

        return 0;
    }
}

solve([7, -2, 8, 9]);
solve([3, -2, 0, -1]);