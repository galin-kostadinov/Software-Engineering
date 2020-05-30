"use strict";

class SortedList {
    constructor() {
        this._array = [];
        this.size = 0;
    }

    add(element) {
        this._array.push(Number(element));
        this.size++;
        this._array.sort((a, b) => a - b);
        return this;
    }

    remove(index) {
        if (index >= 0 && index < this.size) {
            this._array.splice(index, 1);
            this.size--;
            return this;
        }
        throw new Error("Out of bount exeption!");
    }

    get(index) {
        if (index >= 0 && index < this.size) {
            return this._array[index];
        }
        throw new Error("Out of bount exeption!");
    }
}