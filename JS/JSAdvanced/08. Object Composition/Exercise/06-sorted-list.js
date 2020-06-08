"use strict";

function solve() {
    return {
        elements: [],
        size: 0,
        add: function (el) {
            this.elements.push(el);
            this.elements.sort((a, b) => a - b);
            this.size++;
        },
        remove: function (index) {
            if (index >= this.size || index < 0) {
                throw new Error('');
            }
            this.elements.splice(index, 1);
            this.size--;
        },
        get: function (index) {
            if (index >= this.size || index < 0) {
                throw new Error('');
            }
            return this.elements[index];
        },
    };
}

solve();