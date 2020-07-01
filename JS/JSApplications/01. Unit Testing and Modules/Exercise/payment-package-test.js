let PaymentPackage = require('./payment-package');

let assert = require('chai').assert;
const validName = 'Current Package';
const validValue = 1000;

describe('PaymentPackage', () => {
    describe('Instantiation', () => {
        it('works with valid parameters', () => {
            assert.doesNotThrow(() => new PaymentPackage(validName, validValue));
        });

        it('should throw exception with invalid value', () => {
            assert.throw(() => new PaymentPackage(validName, ''));
            assert.throw(() => new PaymentPackage(validName, -3));
            assert.throw(() => new PaymentPackage(validName, {}));
            assert.throw(() => new PaymentPackage(validName, null));
        });

        it('should throw exception with invalid name', () => {
            assert.throw(() => new PaymentPackage('', validValue));
            assert.throw(() => new PaymentPackage(undefined, validValue));
            assert.throw(() => new PaymentPackage({}, validValue));
            assert.throw(() => new PaymentPackage(null, validValue));
        });
    });

    describe('Accessors', () => {
        let instance = null;

        beforeEach(() => {
            instance = new PaymentPackage(validName, validValue);
        });

        describe('set name', () => {
            it('should set the name if newName is valid', () => {
                const newName = "New Package";
                instance.name = newName;
                assert.equal(instance.name, newName);
            });

            it('should throw exception with invalid name', () => {
                assert.throw(() => instance.name = '');
                assert.throw(() => instance.name = undefined);
                assert.throw(() => instance.name = {});
                assert.throw(() => instance.value = null);
            });
        });

        describe('set value', () => {
            it('should set the value if newValue is valid', () => {
                const newValue = 42;
                instance.value = newValue;
                assert.equal(instance.value, newValue);
            });

            it('should throw exception with invalid name', () => {
                assert.throw(() => instance.value = '');
                assert.throw(() => instance.value = -5);
                assert.throw(() => instance.value = {});
                assert.throw(() => instance.value = undefined);
                assert.throw(() => instance.value = null);
            });
        });

        describe('set VAT', () => {
            it('should set the VAT if newVAT is valid', () => {
                const newVAT = 15;
                instance.VAT = newVAT;
                assert.equal(instance.VAT, newVAT);
            });

            it('should throw exception with invalid VAT', () => {
                assert.throw(() => instance.VAT = '');
                assert.throw(() => instance.VAT = -5);
                assert.throw(() => instance.VAT = {});
                assert.throw(() => instance.VAT = undefined);
                assert.throw(() => instance.VAT = null);
            });
        });

        describe('set active', () => {
            it('should set the active if newValue is boolean', () => {
                const newActive = false;
                instance.active = newActive;
                assert.equal(instance.active, newActive);
            });

            it('should throw exception with invalid data type', () => {
                assert.throw(() => instance.active = '');
                assert.throw(() => instance.active = -5);
                assert.throw(() => instance.active = {});
                assert.throw(() => instance.active = "abc");
                assert.throw(() => instance.active = undefined);
                assert.throw(() => instance.active = null);
            });
        });
    });

    describe('String info', () => {
        let instance = null;

        beforeEach(() => {
            instance = new PaymentPackage(validName, validValue);
        });

        it('should contain name', () => {
            assert.isTrue(instance.toString().includes(validName));
        });

        it('should contain value', () => {
            assert.isTrue(instance.toString().includes(validValue));
        });

        it('should contain VAT', () => {
            assert.isTrue(instance.toString().includes('20'));
        });

        it('should contain "inactive" when active status is false', () => {
            instance.active = false;
            assert.isTrue(instance.toString().includes('inactive'));
        });

        it('should not contain "inactive" when active status is true', () => {
            assert.isFalse(instance.toString().includes('inactive'));
        });
    });
});