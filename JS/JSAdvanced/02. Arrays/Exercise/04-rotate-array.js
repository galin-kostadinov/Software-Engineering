"use strict";

function solve(arr) {
  let rotCount = Number(arr.pop());

  rotCount %= arr.length;

  for (let i = 0; i < rotCount; i++) {
    arr.unshift(arr.pop());
  }

  console.log(arr.join(' '));
}

solve(
  ['1',
    '2',
    '3',
    '4',
    '2']);