function attachEvents() {
    const baseURL = 'http://localhost:3000/messenger';

    const elements = {
        messagesArea() { return document.querySelector('#messages') },
        author() { return document.querySelector('#author') },
        content() { return document.querySelector('#content') },
        createMessage() { return document.querySelector('#submit') },
        loadMessages() { return document.querySelector('#refresh') }
    };

    elements.createMessage().addEventListener('click', () => {
        const { value: author } = elements.author();
        const { value: content } = elements.content();

        fetch(baseURL, {
            method: "POST",
            body: JSON.stringify({ author, content })
        });
        
        elements.author().value = '';
        elements.content().value = '';
    });

    elements.loadMessages().addEventListener('click', () => {
        elements.messagesArea().innerHTML = '';
        fetch(baseURL)
            .then((response) => response.json())
            .then((result) => {
                Object.values(result).forEach((obj) => {
                    let textNode = document.createTextNode(`${obj.author}: ${obj.content}\n`);
                    elements.messagesArea().appendChild(textNode);
                });
            });
    });
}

attachEvents();