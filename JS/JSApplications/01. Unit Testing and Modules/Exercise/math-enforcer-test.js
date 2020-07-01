let mathEnforcer = require('./math-enforcer');

let assert = require('chai').assert;

let addFive = mathEnforcer.addFive;
let subtractTen = mathEnforcer.subtractTen;
let sum = mathEnforcer.sum;

describe('mathEnforcer', function () {
    describe('addFive()', function () {
        it('should return undefined with no number value', function () {
            assert.equal(addFive("abv"), undefined);
        });

        it('should return number sum with 5 if given argument is number', function () {
            assert.equal(addFive(5), 10);
        });
    });

    describe('subtractTen()', function () {
        it('should return undefined with no number value', function () {
            assert.equal(subtractTen("abv"), undefined);
        });

        it('should return number subtracted with 10 if given argument is number', function () {
            assert.equal(subtractTen(20), 10);
        });
    });

    describe('sum()', function () {
        it('should return undefined if first argument is NaN', function () {
            assert.equal(sum("abv", 2), undefined);
        });

        it('should return undefined if second argument is NaN', function () {
            assert.equal(sum(2, "abv"), undefined);
        });

        it('should return sum of the 2 arguments if they are numbers', function () {
            assert.equal(sum(5, 5), 10);
        });
    });
});