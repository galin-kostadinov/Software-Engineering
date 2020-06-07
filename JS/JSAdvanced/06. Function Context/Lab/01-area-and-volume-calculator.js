"use strict";

function vol() {
    return this.x * this.y * this.z;
};

function area() {
    return this.x * this.y;
};

function solve(area, vol, input) {
    input = JSON.parse(input);

    parseStrToNum();

    function parseStrToNum() {
        for (let coordinates of input) {
            coordinates.x = Number(coordinates.x);
            coordinates.y = Number(coordinates.y);
            coordinates.z = Number(coordinates.z);
        }
    }

    const result = [];

    for (let coordinates of input) {
        result.push({ area: Math.abs(area.call(coordinates)), volume: Math.abs(vol.call(coordinates)) });
    }

    return result;
}

solve(area, vol, `[
    {"x":"10","y":"-22","z":"10"},
    {"x":"47","y":"7","z":"-5"},
    {"x":"55","y":"8","z":"0"},
    {"x":"100","y":"100","z":"100"},
    {"x":"55","y":"80","z":"250"}
    ]`
);