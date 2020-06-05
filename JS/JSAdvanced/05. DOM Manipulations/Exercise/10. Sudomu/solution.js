function solve() {
    const buttens = document.querySelectorAll('button');
    const quickCheckButton = buttens[0];
    const clearButton = buttens[1];

    quickCheckButton.addEventListener('click', quickCheck);
    clearButton.addEventListener('click', clear);

    const inputs = document.querySelectorAll('input');
    const checkDiv = document.querySelector('#check p');
    const table = document.querySelector('#exercise>table');

    function quickCheck(ev) {
        let matrix = fillInputMatrix();

        if (checkIsRigth(matrix)) {
            table.style.border = '2px solid green';
            checkDiv.textContent = 'You solve it! Congratulations!';
            checkDiv.style.color = 'green';
        } else {
            table.style.border = '2px solid red';
            checkDiv.textContent = 'NOP! You are not done yet...';
            checkDiv.style.color = 'red';
        }
    }

    function clear(ev) {
        table.style.border = '';
        checkDiv.textContent = '';

        for (let input of inputs) {
            input.value = '';
        }
    }

    function fillInputMatrix() {
        let size = Math.sqrt(inputs.length);
        let inputIndex = 0;
        const matrix = [];
        for (let row = 0; row < size; row++) {
            const array = [];
            for (let col = 0; col < size; col++) {
                array.push(Number(inputs[inputIndex++].value));
            }
            matrix.push(array);
        }

        return matrix;
    }

    function checkIsRigth(matrix) {
        let size = matrix.length;

        for (let row = 0; row < size; row++) {
            const set = new Set(matrix[row]);
            if (set.size !== size || set.has(0)) {
                return false;
            }
        }

        for (let col = 0; col < size; col++) {
            const set = new Set();
            for (let row = 0; row < size; row++) {
                set.add(matrix[row][col]);
            }
            if (set.size !== size) {
                return false;
            }
        }

        return true;
    }
}