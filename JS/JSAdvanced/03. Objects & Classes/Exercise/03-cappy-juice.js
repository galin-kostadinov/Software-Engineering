"use strict";

function solve(input) {
    let juiceQuantity = {};

    let bottleFill = new Set();

    for (let row of input) {
        const currFruite = row.split(/\s*=>\s*/);

        if (!juiceQuantity.hasOwnProperty(currFruite[0])) {
            juiceQuantity[currFruite[0]] = 0;
        }

        juiceQuantity[currFruite[0]] += Number(currFruite[1]);

        const bottle = Math.floor(juiceQuantity[currFruite[0]] / 1000);
        if ( bottle > 0) {
            bottleFill.add(currFruite[0]);
        }
    }

    for (let key of bottleFill) {
        const bottle = Math.floor(juiceQuantity[key] / 1000);

        if (bottle && bottle > 0) {
            console.log(key + ' => ' + bottle);
        }
    }
}

solve(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']
);

solve(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']
);