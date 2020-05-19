"use strict"

function solve(steps, footprint, speed) {
    let rest = 60;

    let totalLength = steps * footprint;
    let additionalSeconds = rest * Math.floor(totalLength / 500);
    let totalTimeInSec = Math.ceil(3600 * totalLength / (speed * 1000) + additionalSeconds);

    let hour = Math.floor(totalTimeInSec / 3600);
    let min = Math.floor((totalTimeInSec - hour * 3600) / 60);
    let sec = totalTimeInSec - hour * 3600 - min * 60;
    console.log(`${hour.toString().padStart(2, "0")}:${min.toString().padStart(2, "0")}:${sec.toString().padStart(2, "0")}`);
}

solve(4000, 0.60, 5);
solve(2564, 0.70, 5.5);