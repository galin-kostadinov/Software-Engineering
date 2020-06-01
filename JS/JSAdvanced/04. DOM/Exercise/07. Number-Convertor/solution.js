function solve() {
    const selectMenuTo = document.querySelector('#selectMenuTo');

    let binary = createElement('option', 'binary', 'Binary');
    let hexadecimal = createElement('option', 'hexadecimal', 'Hexadeicmal');

    selectMenuTo.appendChild(binary);
    selectMenuTo.appendChild(hexadecimal);

    document.querySelector('#container button').addEventListener('click', calc);

    function calc(ev) {
        let input = Number(document.querySelector('#input').value);

        let output = '';
        if (selectMenuTo.value === 'binary') {
            output = input.toString(2)
        } else if (selectMenuTo.value === 'hexadecimal') {
            output = input.toString(16).toUpperCase();
        }

        document.querySelector('#result').value = output;
    }

    function createElement(type, value, content) {
        let element = document.createElement(type);
        element.value = value;
        element.textContent = content;

        return element;
    }
}