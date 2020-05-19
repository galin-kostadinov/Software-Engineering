"use strict"

function solve(arr) { 
    let result = {};
    for (let i = 0; i < arr.length; i += 2) {
        let name = arr[i];
        let cal = +arr[i + 1];

        result [name] = cal;
    }

    console.log(result);
}

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
solve(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);