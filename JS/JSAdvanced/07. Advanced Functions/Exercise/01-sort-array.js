"use strict";

function sort(array, orderType) {
    const sortBy = {
        asc: (a, b) => a - b,
        desc: (a, b) => b - a
    }

    return array.sort(sortBy[orderType]);
}

console.log(sort([14, 7, 17, 6, 8], 'asc'));