let isOddOrEven = require('./is-odd-or-even');

let assert = require('chai').assert;

describe('isOddOrEven()', function () {
    it('should return undefined with no string value', function () {
        assert.equal(isOddOrEven(1), undefined);
    });

    it('should return even with even string length', function () {
        assert.equal(isOddOrEven("ab"), "even");
    });

    it('should return odd with odd string length', function () {
        assert.equal(isOddOrEven("abv"), "odd");
    });
});