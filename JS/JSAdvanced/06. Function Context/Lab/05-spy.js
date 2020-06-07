"use strict";

function Spy(target, methodName) {
    const originalFunction = target[methodName];

    const result = {
        count: 0
    }

    target[methodName] = function () {
        result.count++
        return originalFunction.apply(this, arguments);
    }

    return result;
}

let obj = {
    method: () => "invoked"
}

let spy = Spy(obj, "method");

obj.method();
obj.method();
obj.method();

console.log(spy) // { count: 3 }