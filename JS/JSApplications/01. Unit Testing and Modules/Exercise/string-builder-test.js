let StringBuilder = require('./string-builder');

let assert = require('chai').assert;

const validString = "Hello, Mocka tests";

describe('StringBuilder', () => {
    describe('Instantiation', () => {
        it('should create array from string if string is non undefined', () => {
            let instance = new StringBuilder(validString)
            assert.equal(instance._stringArray.length, validString.length);
        });

        it('should create empty array if string parameter is undefined', () => {
            let instance = new StringBuilder();
            assert.equal(instance._stringArray.length, 0);
        });

        it('should throw if value is not string or undefined', () => {
            assert.throw(() => new StringBuilder(null));
            assert.throw(() => new StringBuilder({}));
            assert.throw(() => new StringBuilder(1));
            assert.throw(() => new StringBuilder(1.25));
            assert.throw(() => new StringBuilder(true));
        });
    });

    describe('append', () => {
        it('should append new string value', () => {
            let instance = new StringBuilder(validString)
            let newString = "abv";
            instance.append(newString);

            assert.equal(instance._stringArray.length, validString.length + newString.length);

            const array = instance._stringArray;
            let index = 0;
            for (let i = validString.length; i < instance._stringArray.length; i++) {
                assert.equal(array[i], newString[index++]);
            }
        });

        it('should throw if value is not string', () => {
            let instance = undefined;

            beforeEach(() => {
                instance = new StringBuilder(validString)
            });

            assert.throw(() => instance.append(undefined));
            assert.throw(() => instance.append(null));
            assert.throw(() => instance.append(''));
            assert.throw(() => instance.append({}));
            assert.throw(() => instance.append(1));
            assert.throw(() => instance.append(1.25));
            assert.throw(() => instance.append(true));
        });
    });

    describe('prepend', () => {
        it('should append new string value', () => {
            let instance = new StringBuilder(validString)
            let newString = "abv";
            instance.prepend(newString);

            assert.equal(instance._stringArray.length, validString.length + newString.length);

            const array = instance._stringArray;
            for (let i = 0; i < newString.length; i++) {
                assert.equal(array[i], newString[i]);
            }
        });

        it('should throw if value is not string', () => {
            let instance = undefined;

            beforeEach(() => {
                instance = new StringBuilder(validString)
            });

            assert.throw(() => instance.prepend(undefined));
            assert.throw(() => instance.prepend(null));
            assert.throw(() => instance.prepend(''));
            assert.throw(() => instance.prepend({}));
            assert.throw(() => instance.prepend(1));
            assert.throw(() => instance.prepend(1.25));
            assert.throw(() => instance.prepend(true));
        });
    });

    describe('insertAt', () => {
        it('should inset at given index', () => {
            let instance = new StringBuilder(validString)
            let newString = "abv";
            let validIndex = 1;

            instance.insertAt(newString, validIndex);

            assert.equal(instance._stringArray.length, validString.length + newString.length);

            const array = instance._stringArray;
            let index = 0;
            for (let i = validIndex; i < newString.length + validIndex; i++) {
                assert.equal(array[i], newString[index++]);
            }
        });

        it('should throw if value is not string', () => {
            let instance = undefined;
            let validIndex = 1;

            beforeEach(() => {
                instance = new StringBuilder(validString)
            });

            assert.throw(() => instance.insertAt(undefined, validIndex));
            assert.throw(() => instance.insertAt(null, validIndex));
            assert.throw(() => instance.insertAt('', validIndex));
            assert.throw(() => instance.insertAt({}, validIndex));
            assert.throw(() => instance.insertAt(1, validIndex));
            assert.throw(() => instance.insertAt(1.25, validIndex));
            assert.throw(() => instance.insertAt(true, validIndex));
        });
    });

    describe('remove', () => {
        it('should remove characters in given range', () => {
            let instance = new StringBuilder(validString)
            let startIndex = 7;
            let length = 5;

            instance.remove(startIndex, length);
            let array = instance._stringArray;

            assert.equal(array.length, validString.length - length);
            assert.isFalse(array.includes('Mocha'));
        });
    });

    describe('toString', () => {
        it('should remove StringBuilder as string', () => {
            let instance = new StringBuilder(validString)
            assert.equal(instance.toString(), validString);
        });
    });
});
