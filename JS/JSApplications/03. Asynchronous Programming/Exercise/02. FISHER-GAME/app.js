function attachEvents() {
    const urlGetPostCatches = 'https://fisher-game.firebaseio.com/catches.json';

    const inputAngler = document.querySelector('#addForm input.angler');
    const inputWeight = document.querySelector('#addForm input.weight');
    const inputSpecies = document.querySelector('#addForm input.species');
    const inputLocation = document.querySelector('#addForm input.location');
    const inputBait = document.querySelector('#addForm input.bait');
    const inputCaptureTime = document.querySelector('#addForm input.captureTime');

    const catchesDiv = document.querySelector('#catches');
    const pattern = catchesDiv.children[0];
    pattern.style.display = 'none';

    const loadBnt = document.querySelector('aside button.load');

    loadBnt.addEventListener('click', loadAllCatches);
    document.querySelector('#addForm button.add').addEventListener('click', addCatch);

    function loadAllCatches(ev) {
        fetch(urlGetPostCatches, { method: 'GET' })
            .then((res) => res.json())
            .then((caches) => showAllCatches(caches))
            .catch((err) => alert(err));
    }

    function addCatch(ev) {
        const catchElement = ev.target.parentNode;

        let data = [...catchElement.children]
            .filter(el => el.tagName === 'INPUT')
            .reduce((obj, currEl) => {
                const prop = currEl.className;
                obj[prop] = currEl.value;
                return obj;
            }, {});

        const catchId = catchElement['data-id'];

        if (!(Object.values(data).indexOf('') > -1)) {
            fetch(urlGetPostCatches, {
                method: 'POST',
                body: JSON.stringify(data)
            }).then((data) =>{
                clearInput();
                loadBnt.click();
            } )
                .catch((err) => alert(err));
        } else {
            alert("Input field is mandatory.");
        }

        function clearInput(){
            [...catchElement.children]
            .filter(el => el.tagName === 'INPUT')
            .map(el => el.value = '');   
        }
    }

    function updateCatch(ev) {
        const catchElement = ev.target.parentNode;

        let data = [...catchElement.children]
            .filter(el => el.tagName === 'INPUT')
            .reduce((obj, currEl) => {
                const prop = currEl.className;
                obj[prop] = currEl.value;
                return obj;
            }, {});

        const catchId = catchElement['data-id'];

        if (!(Object.values(data).indexOf('') > -1)) {
            fetch(`https://fisher-game.firebaseio.com/catches/${catchId}.json`, {
                method: 'PUT',
                body: JSON.stringify(data)
            }).then((data) => loadBnt.click())
                .catch((err) => alert(err));
        } else {
            alert("Input field is mandatory.");
        }
    }

    function deleteCatch(ev) {
        const catchId = event.currentTarget.parentNode.getAttribute('data-id');
        const catchElement = event.currentTarget.parentNode;

        fetch(`https://fisher-game.firebaseio.com/catches/${catchId}.json`, {
            method: 'DELETE'
        }).then(catchElement.remove())
            .catch((err) => alert(err));
    }

    function showAllCatches(caches) {
        catchesDiv.innerHTML = '';

        Object.keys(caches).forEach((key) => {
            const catchElement = pattern.cloneNode(true);

            catchElement.style.display = 'inline-block';
            catchElement.setAttribute('data-id', key);
            catchElement.querySelector('input.angler').value = caches[key].angler;
            catchElement.querySelector('input.weight').value = caches[key].weight;
            catchElement.querySelector('input.species').value = caches[key].species;
            catchElement.querySelector('input.location').value = caches[key].location;
            catchElement.querySelector('input.bait').value = caches[key].bait;
            catchElement.querySelector('input.captureTime').value = caches[key].captureTime;

            catchElement.querySelector('button.update').addEventListener('click', updateCatch);
            catchElement.querySelector('button.delete').addEventListener('click', deleteCatch);

            catchesDiv.appendChild(catchElement);
        });
    }
}

attachEvents();