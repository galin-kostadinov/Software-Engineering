"use strict";

function arrayMap(elements, func) {
    return elements.reduce((acc, el) => [...acc, func(el)], []);
}

let nums = [1, 2, 3, 4, 5];
console.log(arrayMap(nums, (item) => item * 2)); // [ 2, 4, 6, 8, 10 ]

let letters = ["a", "b", "c"];
console.log(arrayMap(letters, (l) => l.toLocaleUpperCase()))я