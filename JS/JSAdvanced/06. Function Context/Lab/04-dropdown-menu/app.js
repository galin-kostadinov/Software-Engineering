function solve() {
    document.querySelector('body').addEventListener('click', handler)
    const dropdownUl = document.querySelector('#dropdown-ul');
    const box = document.querySelector('#box');


    function handler(ev) {
        const evTarget = ev.target;
        if (evTarget.id === 'dropdown') {
            if (dropdownUl.style.display !== 'block') {
                dropdownUl.style.display = 'block';
            } else {
                box.style.backgroundColor = 'black';
                box.style.color = 'white';
                dropdownUl.style.display = 'none';
            }
        } else if (evTarget.tagName === 'LI' && evTarget.parentElement.id === 'dropdown-ul') {
            box.style.backgroundColor = evTarget.textContent;
            box.style.color = 'black';
        }
    }
}