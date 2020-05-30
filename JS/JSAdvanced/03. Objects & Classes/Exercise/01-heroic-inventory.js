"use strict";

function solve(input) {
    let result = [];

    for(const row of input){
        const currRowEl = row.split(/\s*\/\s*/);
        let obj = {};
        obj.name = currRowEl[0];
        obj.level = Number(currRowEl[1]);

        let items = currRowEl[2];
        items = items ? items.split(/\s*,\s*/) : [];

        obj.items = items;

        result.push(obj);
    }

    return JSON.stringify(result);
}

console.log(
    solve(['Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara'])
);

console.log(
    solve(['Jake / 1000 / '])
);