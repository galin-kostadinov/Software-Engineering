"use strict";

function solve(input) {
    let collection = new Map();

    const innerOperations = {
        create,
        set,
        print
    }

    input.forEach(el => {
        const [command, ...params] = el.split(' ');
        innerOperations[command](...params);
    });

    function create(name, _, parentName) {
        let parent = collection.get(parentName) || null;
        let newObj = Object.create(parent);

        collection.set(name, newObj);
    }

    function set(name, key, value) {
        collection.get(name)[key] = value;
    }

    function print(name) {
        const obj = collection.get(name);
        const result = [];

        for (const key in obj) {
            result.push(`${key}:${obj[key]}`);
        }

        console.log(result.join(', '));
    }
}


solve(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']);