"use strict";

function solve(obj) {
    let enginesCatalog = [
        { power: 90, volume: 1800 },
        { power: 120, volume: 2400 },
        { power: 200, volume: 3500 },
    ];

    return {
        model: obj.model,
        engine: enginesCatalog.find(eng => eng.power >= obj.power),
        carriage: {
            type: obj.carriage,
            color: obj.color
        },
        wheels: new Array(4).fill(obj.wheelsize % 2 !== 0 ? obj.wheelsize : obj.wheelsize - 1)
    };
}

console.log(solve({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}));