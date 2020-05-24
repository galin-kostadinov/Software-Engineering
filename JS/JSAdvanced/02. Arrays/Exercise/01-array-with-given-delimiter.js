"use strict";

function solve(arr) {
    const delimiter = arr.pop();

    console.log(arr.join(delimiter));
}

solve(
    ['One',
        'Two',
        'Three',
        'Four',
        'Five',
        '-']);