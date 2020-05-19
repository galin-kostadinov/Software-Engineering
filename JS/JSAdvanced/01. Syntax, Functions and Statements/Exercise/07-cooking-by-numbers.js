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

solve(['32', 'chop', 'chop', 'chop', 'chop', 'chop']);
solve(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);