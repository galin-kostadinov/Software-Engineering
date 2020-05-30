"use strict";

function solve(input) {
    let result = {};

    for (const row of input) {
        let [brand, model, quantity] = row.split(/\s*\|\s*/);

        if (!result.hasOwnProperty(brand)) {
            result[brand] = {};
        }

        if (!result[brand].hasOwnProperty(model)) {
            result[brand][model] = 0;
        }

        result[brand][model] += Number(quantity);
    }

    for (let brand of Object.keys(result)) {
        console.log(brand);
        for (let model of Object.keys(result[brand])) {
            console.log(`###${model} -> ${result[brand][model]}`)
        }
    }
}

solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']);