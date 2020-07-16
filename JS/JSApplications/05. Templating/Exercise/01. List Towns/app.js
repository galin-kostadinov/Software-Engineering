window.addEventListener('load', () => {
    document.querySelector('#btnLoadTowns').addEventListener('click', getInput);
    let input = document.querySelector('#towns');
    let result = document.querySelector('#root');
    const template = document.querySelector('#towns-template').innerHTML;
    const compiled = Handlebars.compile(template);

    function getInput(ev) {
        ev.preventDefault();
        if (input.value) {
            let towns = input.value.split(/,/).map(e => e.trim());
            input.value = '';
            renderTowns(towns);
        }
    }

    function renderTowns(towns) {
        const rendered = compiled({ towns });
        result.innerHTML = rendered;
    }
}); 