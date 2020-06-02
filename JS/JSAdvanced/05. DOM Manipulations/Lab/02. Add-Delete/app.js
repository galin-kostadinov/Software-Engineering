function addItem() {
    const input = document.querySelector('#newText');
    let inputValue = input.value;

    if (inputValue.trim()) {
        const items = document.querySelector('#items');
        
        let newItemLi = document.createElement('li');
        newItemLi.textContent = inputValue;

        let newHref = document.createElement('a');
        newHref.setAttribute('href', '#');
        newHref.textContent = '[Delete]';
        newHref.addEventListener('click', deleteItem);
        
        newItemLi.appendChild(newHref);

        items.appendChild(newItemLi);

        input.value = '';
    }

    function deleteItem(ev) {
        ev.target.parentElement.remove()
        console.log(ev.target);
    }
}