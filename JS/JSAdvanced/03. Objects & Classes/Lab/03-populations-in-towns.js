"use-strict";

function solve(arr) {
    let obj = {};

    for (let i = 0; i < arr.length; i++) {
        let row = arr[i].split(/\s*<->\s*/);

        if (!obj.hasOwnProperty(row[0])) {
            obj[row[0]] = 0;
        }

        obj[row[0]] += Number(row[1]);
    }

    for (const key of Object.keys(obj)) {
        console.log(key + ' : ' + obj[key]);
    }
}

solve(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']);