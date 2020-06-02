function validate() {
    const regex = /[a-z\.]+@[a-z]+.[a-z]+/g;

    const inputHTML = document.querySelector('input');
    inputHTML.addEventListener('change', change);
   
    function change(ev) {
        let imputEmail = ev.target.value;

        if (regex.exec(imputEmail) !== null) {
            ev.target.classList.remove('error');
        } else {
            ev.target.classList.add('error');
        }
    }
}