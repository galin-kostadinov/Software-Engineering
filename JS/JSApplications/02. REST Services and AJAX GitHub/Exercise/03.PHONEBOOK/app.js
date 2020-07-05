function attachEvents() {
    const baseURL = 'http://localhost:3000/phonebook';

    const elements = {
        person() { return document.querySelector('#person') },
        phone() { return document.querySelector('#phone') },
        createContact() { return document.querySelector('#btnCreate') },
        loadContacts() { return document.querySelector('#btnLoad') },
        phonebook() { return document.querySelector('#phonebook') }
    };

    elements.createContact().addEventListener('click', () => {
        const { value: person } = elements.person();
        const { value: phone } = elements.phone();

        fetch(baseURL, {
            method: "POST",
            body: JSON.stringify({ person, phone })
        });

        elements.person().value = '';
        elements.phone().value = '';
    });

    elements.loadContacts().addEventListener('click', () => {
        elements.phonebook().innerHTML = '';

        fetch(baseURL)
            .then((response) => response.json())
            .then((result) => {

                Object.keys(result).forEach((key) => {
                    let listItem = document.createElement('li');
                    listItem.textContent = `${result[key].person}: ${result[key].phone}`;
                    const deleteBtn = document.createElement('button');
                    deleteBtn.textContent = 'Delete'

                    deleteBtn.addEventListener('click', function () {
                        //Doesn't work due to CORS
                        fetch(baseURL + `/${key}`, {
                            method: "DELETE"
                        });

                        elements.phonebook().removeChild(listItem);
                    });

                    listItem.appendChild(deleteBtn);
                    elements.phonebook().appendChild(listItem);
                });
            });
    });
}

attachEvents();