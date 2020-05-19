"use strict"

function solve(arr) {
    let num = +arr[0];

    for (let i = 1; i < arr.length; i++) {
        switch (arr[i]) {
            case 'chop': num /= 2;
                break;
            case 'dice': num = Math.sqrt(num);
                break;
            case 'spice': num++;
                break;
            case 'bake': num *= 3;
                break;
            case 'fillet': num *= 0.8;
                break;
        }
        console.log(num);
    }
}

// function cookingByNumbers(input) {
//     let number = Number(input.shift());
 
//     const functions = {
//         chop: (x) => x / 2,
//         dice: (x) => Math.sqrt(x),
//         spice: (x) => x + 1,
//         bake: (x) => x * 3,
//         fillet: (x) => x * 0.8,
//     };
 
//     input.forEach(function (element) {
//         let result = functions[element](number);
//         console.log(result);
//         number = result;
//     });
// }

solve(['32', 'chop', 'chop', 'chop', 'chop', 'chop']);
solve(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);