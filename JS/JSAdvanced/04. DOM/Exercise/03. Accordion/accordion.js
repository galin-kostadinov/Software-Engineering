function toggle() {
    let currentEvent = document.getElementsByClassName("button")[0];

    let divExtra = document.querySelector("#extra");

    if (currentEvent.textContent === 'More') {
        currentEvent.textContent = 'Less';
        divExtra.style.cssText = `display: block;`;
    } else {
        currentEvent.textContent = 'More';
        divExtra.style.cssText = `display: none`;
    }
}

// function toggle() {
//     let currentEvent = event.target;

//     let divExtra = document.querySelector("#extra");

//     if (currentEvent.textContent === 'More') {
//         currentEvent.textContent = 'Less';
//         divExtra.style.cssText = `display: block;`;
//     } else {
//         currentEvent.textContent = 'More';
//         divExtra.style.cssText = `display: none`;
//     }
// }