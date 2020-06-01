function solve() {
    document.querySelector('#exercise button').addEventListener('click', () => {
        let currentInput = document.querySelector("#exercise article input");

        if (currentInput.value !== '') {
            let inputValue = currentInput.value.toLowerCase();

            inputValue = inputValue.substring(0, 1).toUpperCase() + inputValue.substring(1);

            const childIndex = inputValue.charCodeAt(0) - 'A'.charCodeAt(0);

            let dbCurrentLi = document.querySelector(`#exercise div ol li:nth-child(${childIndex + 1})`);

            dbCurrentLi.textContent ? dbCurrentLi.textContent += ', ' + inputValue : dbCurrentLi.textContent = inputValue;

            currentInput.value = '';
        }
    });
}