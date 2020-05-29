"use-strict";

function solve(arr) {
    let head = arr[0].split('|').filter(el => el !== '').map(el => el.trim());

    let objArr = [];

    for (let row = 1; row < arr.length; row++) {
        let currRow = arr[row].split('|').filter(el => el !== '').map(el => el.trim());

        let currObj = {};
        currObj[head[0]] = currRow[0];
        currObj[head[1]] = Number(Number(currRow[1]).toFixed(2));
        currObj[head[2]] = Number(Number(currRow[2]).toFixed(2));

        objArr.push(currObj);
    }

    return JSON.stringify(objArr);
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']);