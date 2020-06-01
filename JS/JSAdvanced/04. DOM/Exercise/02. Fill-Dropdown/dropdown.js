function addItem() {
    let textEl = document.querySelector("#newItemText");
    let valueEl = document.querySelector("#newItemValue");

    const text = textEl.value;
    const value = valueEl.value;

    if (text !== '' && value !== '') {

        let option = document.createElement("option");

        option.value = value;
        option.textContent = text;

        document.querySelector("#menu").appendChild(option);

        textEl.value = '';
        valueEl.value = '';
    }
}