"use strict";

function solve(arr) {
    arr = arr.sort();

    const result = {};

    for (const row of arr) {
        const [product, price] = row.split(/\s:\s*/);
        let char = product[0];

        if (!result.hasOwnProperty(char)) {
            result[char] = [];
        }

        let arrPr = result[char];
        const obj = {};
        obj[product] = Number(price);

        arrPr.push(obj)
    }

    const sortedKey = Object.keys(result).sort((a, b) => a.localeCompare(b));

    for (let key of sortedKey) {
        console.log(key);

        for (let kvp of Object.entries(result[key])) {
            let entrie = Object.entries(kvp[1]);
            console.log('  ' + entrie[0][0] + ': ' + entrie[0][1]);
        }
    }
}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499', 
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']);