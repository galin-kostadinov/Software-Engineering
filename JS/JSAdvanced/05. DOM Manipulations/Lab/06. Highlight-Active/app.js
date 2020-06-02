function focus() {
    const divs = document.querySelectorAll('input');

    for (let div of divs) {
        div.addEventListener('focus', setFocuced);
        div.addEventListener('blur', removeFocuced);
    }

    function setFocuced(ev) {
        ev.target.parentNode.classList.add('focused');
    }

    function removeFocuced(ev) {
        ev.target.parentNode.classList.remove('focused');
    }
}