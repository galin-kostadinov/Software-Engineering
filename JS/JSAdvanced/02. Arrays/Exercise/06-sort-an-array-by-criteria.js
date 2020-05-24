"use strict";

function solve(arr) {
    arr.sort(sortByLengthAndAlphabet).forEach(el => console.log(el));

    function sortByLengthAndAlphabet(a, b) {
        let sort = a.length - b.length;

        if (sort == 0) {
            let nameA = a.toUpperCase();
            let nameB = b.toUpperCase();
            if (nameA < nameB) { return -1; }
            if (nameA > nameB) { return 1; }
        }

        return sort;
    }
}

// solve(
//     ['alpha',
//         'beta',
//         'gamma']);

solve(
    ['test',
        'Deny',
        'omen',
        'Default']);