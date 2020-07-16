import monkeys from './monkeys.js';

window.addEventListener('load', async () => {
    const section = document.querySelector('section');

    const divString = await (await fetch('./main.hbs')).text();
    const mainTemplate = Handlebars.compile(divString);

    Handlebars.registerPartial('monkey', await (await fetch('./monkey.hbs')).text());

    const html = mainTemplate({ monkeys });
    section.innerHTML = html;

    const monkeysEl = document.querySelector('div.monkeys');
    monkeysEl.addEventListener('click', onClick);

    function onClick(e) {
        if (e.target.tagName === 'BUTTON') {
            let pEl = e.target.parentNode.querySelector('p');
            if (pEl.style && pEl.style.display === 'none') {
                pEl.style.display = 'block';
            } else {
                //added as additional functionality - hiding 
                pEl.style.display = 'none';
            }
        }
    }
})