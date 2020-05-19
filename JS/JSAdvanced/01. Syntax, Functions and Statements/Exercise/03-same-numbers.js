"use strict"

function solve(num) {
    let numAsStr = num + '';
    let isSame = true;
    let sum = 0;
    let firstDigit = numAsStr[0]
    sum += Number(firstDigit);
    for (let i = 1; i < numAsStr.length; i++) {
        if (numAsStr[i] != firstDigit) {
            isSame = false;
        }
        
        sum += Number(numAsStr[i]);
    }
   
    console.log(isSame);
    console.log(sum);
}

solve(2222222);
solve(1234);