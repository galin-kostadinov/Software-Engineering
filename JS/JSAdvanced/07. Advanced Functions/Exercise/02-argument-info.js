"use strict";

function solve(...args) {
    const myMap = new Map();

    for (let arg of Array.from(args)) {
        const type = typeof arg;

        console.log(`${type}: ${arg}`);
        if (!myMap.has(type)) {
            myMap.set(type, 0);
        }

        myMap.set(type, myMap.get(type) + 1);
    }

    let sortedMap = new Map([...myMap].sort((a, b) => (b[1] - a[1])));

    for (let [key, value] of sortedMap.entries()) {
        console.log(`${key} = ${value}`);
    }
}

solve('cat', 42, function () { console.log('Hello world!'); });