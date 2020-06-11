"use strict";

function solve() {
    class Melon {
        constructor(weight, melonSort) {
            if (new.target === Melon) {
                throw new TypeError('Abstract class cannot be instantiated directly');
            }
            this.weight = weight;
            this.melonSort = melonSort;
        }

        toString() {
            return `Element: ${this.element}\n` +
                `Sort: ${this.melonSort}\n` +
                `Element Index: ${this.elementIndex}`;
        }
    }

    class Watermelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Water';
        }

        get elementIndex() {
            return this.weight * this.melonSort.length;
        }
    }

    class Firemelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Fire';
        }

        get elementIndex() {
            return this.weight * this.melonSort.length;
        }
    }

    class Earthmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Earth';
        }

        get elementIndex() {
            return this.weight * this.melonSort.length;
        }
    }

    class Airmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Air';
        }

        get elementIndex() {
            return this.weight * this.melonSort.length;
        }
    }

    class Melolemonmelon extends Watermelon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.types = [Fire, Earth, Air, Water];
            this.index = 0;
        }

        morph() {
            this.index %= this.types.length;
            this.element = types[this.index];
            this.index++;
        }
    }

    return {
        Melon,
        Watermelon,
        Firemelon,
        Earthmelon,
        Airmelon,
        Melolemonmelon
    };
}

//Throws error
// let test = new Melon(100, "Test");

let watermelon = new Watermelon(12.5, "Kingsize");
console.log(watermelon.toString());