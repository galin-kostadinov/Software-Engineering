"use strict";

(function () {
    function ensureStart(str) {
        return this.startsWith(str) ? this.toString() : str + this.toString();
    }

    function ensureEnd(str) {
        return this.endsWith(str) ? this.toString() : this.toString() + str;
    }

    function isEmpty() {
        return this.length === 0;
    }

    function truncate(n) {
        if (n < 4) {
            return '.'.repeat(n);
        }
        if (this.length <= n) {
            return this.toString();
        }
        const index = this.substr(0, n - 2).lastIndexOf(' ');
        if (index === - 1) {
            return `${this.substr(0, n - 3)}...`;
        }
        return `${this.substr(0, index)}...`;
    }

    function format(string, ...params) {
        return params.reduce((acc, el, index) => acc.replace(`{${index}}`, el), string);
    }

    String.prototype.ensureStart = ensureStart;
    String.prototype.ensureEnd = ensureEnd;
    String.prototype.isEmpty = isEmpty;
    String.prototype.truncate = truncate;
    String.format = format;
})();

let str = 'my string';
str = str.ensureStart('my');
str = str.ensureStart('hello ');
str = str.truncate(16);
str = str.truncate(14);
str = str.truncate(8);
str = str.truncate(4);
str = str.truncate(2);
str = String.format('The {0} {1} fox',
    'quick', 'brown');
str = String.format('jumps {0} {1}',
    'dog');