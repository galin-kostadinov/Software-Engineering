let add = (function () {
    let acc = 0;

    function result(inputNum) {
        acc += inputNum;
        return result;
    }

    result.toString = () => acc.toString();

    return result;
})();

console.log(add(1)(6)(-3).toString());