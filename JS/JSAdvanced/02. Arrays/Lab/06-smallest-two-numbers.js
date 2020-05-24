"use strict"

function solve(arr) {
    let newArr = arr.sort(sortAsc).filter((el, index) => index < 2);

    console.log(newArr.join(' '));
    function sortAsc(a, b) {
        return a - b;
    }
}

solve([30, 15, 50, 5]);
solve([3, 0, 10, 4, 7, 3]);