"use strict";

function solve(arr) {
    return arr
        .map(el => {
            let [width, height] = el;

            return {
                width: width,
                height: height,
                area: function () {
                    return this.width * this.height;
                },
                compareTo: function (other) {
                    return other.area() - this.area() || other.width - this.width;
                }
            }
        })
        .sort((a, b) => {
            let sort = b.area() - a.area();
            if (sort === 0) {
                sort = b.width - a.width;
            }
            return sort;
        });
}


console.log(solve([[10, 5], [5, 12]]));

console.log(solve([[10, 5], [3, 20], [5, 12]]));