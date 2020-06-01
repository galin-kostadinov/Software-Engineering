function solve() {
    document.addEventListener('click', eventHandler);

    let input = document.querySelector('#expressionOutput');
    let output = document.querySelector('#resultOutput');

    function eventHandler(ev) {
        const operators = ['+', '-', '*', '/'];

        if (ev.target.nodeName === 'BUTTON') {
            if (ev.target.value === 'Clear') {
                input.textContent = '';
                output.textContent = '';
                return;
            }

            if (ev.target.value === '=') {
                let expressionOutputArray = input.textContent.split(' ').filter(el => el !== '');

                if (expressionOutputArray.length !== 3) {
                    output.textContent = 'NaN';
                    return;
                }

                try {
                    let result = Number(expressionOutputArray[0]);

                    switch (expressionOutputArray[1]) {
                        case "/":
                            result /= Number(expressionOutputArray[2]);
                            break;
                        case "*":
                            result *= Number(expressionOutputArray[2]);
                            break;
                        case "-":
                            result -= Number(expressionOutputArray[2]);
                            break;
                        case "+":
                            result += Number(expressionOutputArray[2]);
                            break;
                    }

                    output.textContent = result;
                } catch (e) {
                    output.textContent = 'NaN';
                }
            } else {
                input.textContent += operators.includes(ev.target.value) ? ' ' + ev.target.value + ' ' : ev.target.value;
            }
        }
    }
}