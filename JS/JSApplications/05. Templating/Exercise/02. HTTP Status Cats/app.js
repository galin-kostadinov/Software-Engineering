window.addEventListener('load', async () => {
    const allCatsEl = document.querySelector('#allCats');
    
    const listString = await (await fetch('./list.hbs')).text();
    const listTemplate = Handlebars.compile(listString);

    Handlebars.registerPartial('cat', await (await fetch('./cat.hbs')).text());

    const html = listTemplate({ cats });
    allCatsEl.innerHTML = html;

    allCatsEl.addEventListener('click', onClick);

    function onClick(e) {
        if (e.target.tagName === 'BUTTON') {
            let divEl = e.target.parentNode.querySelector('div.status');
            if (divEl.style && divEl.style.display === 'none') {
                divEl.style.display = 'block';
                e.target.textContent = 'Hide status code';
            } else {
                divEl.style.display = 'none';
                e.target.textContent = 'Show status code';
            }
        }
    }
})