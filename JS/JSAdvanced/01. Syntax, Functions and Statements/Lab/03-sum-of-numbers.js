"use strict";

function solve(n, m) {
    let sum = 0;

    let nNum = +n;
    let mNum = +m;
    for (let i = nNum; i <= mNum; i++) {
        sum += i;
    }

    console.log(sum);
}

solve('1', '5');