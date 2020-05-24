"use strict"

function solve(arr) {
    let resultArr = arr.filter((el, index) => index % 2 == 1).map(el => el * 2).reverse();
    console.log(resultArr.join(' '));
}

solve([10, 15, 20, 25]);
solve([3, 0, 10, 4, 7, 3]);