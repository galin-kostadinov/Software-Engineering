"use strict";

function solve(comands) {
    let initialEl = 1;
    let arr = [];

    for (let i = 0; i < comands.length; i++) {
        if (comands[i] === 'add') {
            arr.push(initialEl);
        } else {
            arr.pop();
        }
        initialEl++;
    }

    if (arr.length != 0) {
        arr.forEach(el => console.log(el));
    } else {
        console.log('Empty');
    }
}

solve(
    ['add',
        'add',
        'add',
        'add']);