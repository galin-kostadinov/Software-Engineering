"use strict";

function solve(arr) {
    let result = arr.reduce((acc, el) => acc = pushBigger(acc, el), [arr[0]]);

    function pushBigger(acc, el) {
        if (acc[acc.length - 1] <= el) {
            acc.push(el);
        }
        return acc;
    }
    result.shift();
    result.forEach(el => console.log(el));
}

solve(
    [1,
        3,
        8,
        4,
        10,
        12,
        3,
        2,
        24]);