"use strict";

class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(length) {
        if (length > 0) {
            this.innerLength += length;
        }
    }

    decrease(length) {
        length >= this.innerLength ? this.innerLength = 0 : this.innerLength -= length;
    }

    toString() {
        if (this.innerString.length > this.innerLength) {
            return this.innerString.substr(0, this.innerLength) + '...';
        } else {
            return this.innerString;
        }
    }
}