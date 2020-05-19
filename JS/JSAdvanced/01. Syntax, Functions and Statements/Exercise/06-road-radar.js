"use strict"

function solve(arr) {
    let area = arr[1];
    let speed = arr[0];

    const motorwayMaxSpeed = 130;
    const interstateMaxSpeed = 90;
    const cityMaxSpeed = 50;
    const residentialMaxSpeed = 20;

    switch (area) {
        case 'motorway':
            speedTest(speed - motorwayMaxSpeed);
            break;
        case 'interstate':
            speedTest(speed - interstateMaxSpeed);
            break;
        case 'city':
            speedTest(speed - cityMaxSpeed);
            break;
        case 'residential':
            speedTest(speed - residentialMaxSpeed);
            break;
    }

    function speedTest(speedDiff) {
        if (speedDiff > 0 && speedDiff <= 20) {
            console.log('speeding')
        } else if (speedDiff > 0 && speedDiff <= 40) {
            console.log('excessive speeding')
        } else if (speedDiff > 40) {
            console.log('reckless driving')
        }
    }
}

// function radar(input) {
//     let speed = input[0];
//     let area = input[1];
 
//     const limits = {motorway: 130, interstate: 90, city: 50, residential: 20};
 
//     let printMessage = (speed, limit) => {
//         if (speed > limit + 40) {
//             console.log('reckless driving');
//         } else if (speed > limit + 20) {
//             console.log('excessive speeding ');
//         } else if (speed > limit) {
//             console.log('speeding');
//         }
//     };
//     printMessage(speed, limits[area]);
// }

solve([40, 'city']);
solve([21, 'residential']);