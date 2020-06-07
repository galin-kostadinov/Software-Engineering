"use strict";

function solve(jsonImput) {
    let array = JSON.parse(jsonImput);

    let result = {};
    Object.assign(result, ...array);

    return result;
}

solve(`[{"canMove": true},{"canMove":true, "doors": 4},{"capacity": 5}]`);
solve(`[{"canFly": true},{"canMove":true, "doors": 4},{"capacity": 255},{"canFly":true, "canLand": true}]`);
solve(`[{"prop1": 1},{"prop2":2},{"prop3":3}]`);