function addItem() {
    const input = document.querySelector('#newItemText');
    let inputValue = input.value;

    if (inputValue.trim()) {
        const items = document.querySelector('#items');
        let newItemLi = document.createElement('li');

        newItemLi.textContent = inputValue;
        items.appendChild(newItemLi);

        input.value = '';
    }
}