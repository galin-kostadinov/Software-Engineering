function solution(first) {
    let result = first;
    return function (next) {
        return result + next;
    }
}

let add5 = solution(5);
console.log(add5(2));
console.log(add5(3));