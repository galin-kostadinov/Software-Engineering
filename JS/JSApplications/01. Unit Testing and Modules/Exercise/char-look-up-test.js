let lookupChar = require('./char-look-up');

let assert = require('chai').assert;

describe('lookupChar()', function () {
    it('should return undefined with no string value as first argument', function () {
        assert.equal(lookupChar(1, 1), undefined);
    });

    it('should return undefined with no integer value as second argument', function () {
        assert.equal(lookupChar("abv", 1.25), undefined);
    });

    it('should return "Incorrect index" if index is bigger or equal to string length', function () {
        assert.equal(lookupChar("abv", 3), "Incorrect index");
    });

    it('should return "Incorrect index" if index is negative value', function () {
        assert.equal(lookupChar("abv", -1), "Incorrect index");
    });

    it('should return the character at index if index is between 0 and string.length - 1', function () {
        assert.equal(lookupChar("abv", 1), 'b');
    });
});