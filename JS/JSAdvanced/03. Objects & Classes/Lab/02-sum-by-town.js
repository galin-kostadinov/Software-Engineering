"use-strict";

function solve(arr) {
    let obj = {};

    for (let i = 0; i < arr.length; i += 2) {
        if(!obj.hasOwnProperty(arr[i])){
            obj[arr[i]] = 0;
        }
        
        obj[arr[i]] += Number(arr[i + 1]);
    }

    return JSON.stringify(obj);
}

console.log(solve(['Sofia', '20', 'Varna', '3', 'Sofia', '5', 'Varna', '4']));
