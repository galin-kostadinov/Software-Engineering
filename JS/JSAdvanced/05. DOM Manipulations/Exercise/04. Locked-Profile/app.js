function lockedProfile() {
    let buttens = document.querySelectorAll('#main button');
    for (let button of buttens) {
        button.addEventListener('click', showMore);
    }

    function showMore(ev) {
        const profileDiv = ev.target.parentElement;
        const userHiddenFields = profileDiv.querySelector('div');
        const radioLock = profileDiv.querySelector("input[type='radio'][value='lock']").checked;
        const radioUnlock = profileDiv.querySelector("input[type='radio'][value='unlock']").checked;

        let textContent = ev.target.textContent;

        if (radioLock) {
            return;
        }

        if (radioUnlock && textContent == 'Show more') {
            userHiddenFields.style.display = 'block';
            ev.target.textContent = 'Hide it';
        } else if (radioUnlock && textContent == 'Hide it') {
            userHiddenFields.style.display = 'none';
            ev.target.textContent = 'Show more';
        }
    }
}