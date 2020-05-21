"use strict";

function solve(n, k) {
    const arr = [1];

    for (let index = 1; index < n; index++) {
        arr.push(sum(index));

    }
    
    function sum(index) {
        return arr.slice(index-k < 0 ? 0 : index-k, index+1).reduce((sum, el) => sum + el, 0);
    }

    console.log(arr.join(' '));
}

solve(6, 3);
solve(8, 2);