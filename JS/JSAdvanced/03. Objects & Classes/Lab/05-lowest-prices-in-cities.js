"use-strict";

function solve(input) {
    let result = new Map();

    for (let row of input) {
        let [town, product, price] = row.split(/\s*\|\s*/);
        price = Number(price);

        if (result.has(product)) {
            let kvp = result.get(product);
            if (kvp.price > price) {
                kvp.town = town;
                kvp.price = price;
            }
        } else {
            result.set(product, { town: town, price: price });
        }
    }

    result.forEach((kvp, product) => console.log(`${product} -> ${kvp.price} (${kvp.town})`));
}

solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']);

solve([
    'Sofia City | Audi | 100000',
    'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'New York City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Mexico City | Audi | 100000',
    'Washington City | Mercedes | 1000',
]);