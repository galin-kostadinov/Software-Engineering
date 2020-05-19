"use strict";

function solve(args){
    // args = Array.from(args);
    
    let sum = 0;
    let sum2 = 0;
    let concat = '';

    for(let i = 0; i < args.length; i++){
        sum += args[i];
        sum2 += 1 / args[i];
        concat += args[i];
    }

    console.log(sum);
    console.log(sum2);
    console.log(concat);
}

solve([1, 2, 3]);