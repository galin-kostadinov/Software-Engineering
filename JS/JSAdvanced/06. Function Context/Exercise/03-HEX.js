"use strict";

class Hex {
    constructor(value) {
        this.value = value;
    }

    valueOf() {
        return this.value;
    }

    toString() {
        return '0x' + this.value.toString(16).toUpperCase();
    }

    plus(number) {
        if (number instanceof Hex) {
            return new Hex(this.value + number.value);
        } else {
            return new Hex(this.value + value);
        }
    }

    minus(number) {
        if (number instanceof Hex) {
            return new Hex(this.value - number.value);
        } else {
            return new Hex(this.value - value);
        }
    }

    static parse(string) {
        return string.toString(10);
    }
}


let FF = new Hex(255);
console.log(FF.toString());
FF.valueOf() + 1 == 256;
let a = new Hex(10);
let b = new Hex(5);
console.log(a.plus(b).toString());
console.log(a.plus(b).toString() === '0xF');