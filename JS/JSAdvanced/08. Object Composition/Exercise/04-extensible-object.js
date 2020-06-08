"use strict";

function solve() {
    function extend(template) {
        for (const key in template) {
            if (typeof template[key] === 'function') {
                this.__proto__[key] = template[key];
            } else {
                this[key] = template[key];
            }
        }

        return this;
    }

    return { extend };
}

let obj = solve();
console.log(obj.extend);
