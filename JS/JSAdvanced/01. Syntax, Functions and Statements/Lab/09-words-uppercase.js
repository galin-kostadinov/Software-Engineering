"use strict";

function solve(str){
    const regex = /[A-Za-z0-9]+/gm;
    let m;
    let arr =[];
    while ((m = regex.exec(str)) !== null) {
        // This is necessary to avoid infinite loops with zero-width matches
        if (m.index === regex.lastIndex) {
            regex.lastIndex++;
        }
        
        m.forEach((match) => {
           arr.push(match.toUpperCase()); 
        });
    }

    console.log(arr.join(', '));   
}

solve('hello');