function solution() {
    let storedValue = '';

    return {
        append: (str) => storedValue += str,
        removeStart: (n) => storedValue = storedValue.substr(n),
        removeEnd: (n) => storedValue = storedValue.substr(0, storedValue.length - n),
        print: () => console.log(storedValue)
    };
}

//Test
let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();