"use strict";

function solve(arr) {
    const step = Number(arr.pop());

    arr.filter((el, index) => index % step === 0).forEach(element => {
        console.log(element);
    });
}

solve(
    ['5',
        '20',
        '31',
        '4',
        '20',
        '2']);