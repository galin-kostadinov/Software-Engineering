"use strict";

function getFibonator() {
    let current = 1;
    let next = 1;

    return function () {
        let result = current;
        let temp = next;
        next = next + current;
        current = temp;

        return result;
    }
}

let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13