function subtract() {
    const firstNumber = Number(document.querySelector("#firstNumber").value);
    const secondNumber = Number(document.querySelector("#secondNumber").value);

    const result = firstNumber - secondNumber;

    let divResult = document.querySelector("#result");
    divResult.textContent = result;
}   