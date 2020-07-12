import el from './dom.js';
import * as api from './data.js';

window.addEventListener('load', () => {
    const btnLoad = document.querySelector('#loadBooks');
    btnLoad.addEventListener('click', displayBook);
    const tableBody = document.querySelector('table tbody');
    const createBtn = document.querySelector('form > button');

    const input = {
        title: document.querySelector('#title'),
        author: document.querySelector('#author'),
        isbn: document.querySelector('#isbn')
    }

    createBtn.addEventListener('click', createBook);

    async function createBook(ev) {
        ev.preventDefault();

        if (validateInput(input) == false) {
            alert(`All fields are required!`);
            return;
        }

        const book = {
            title: input.title.value,
            author: input.author.value,
            isbn: input.isbn.value
        }

        try {
            toggleInput(true, ...Object.values(input), createBtn);
            const created = await api.createBook(book);
            tableBody.appendChild(renderBook(created));
            Object.entries(input).forEach(([k, v]) => v.value = '');
        } catch (err) {
            alert(err);
        } finally {
            toggleInput(false, ...Object.values(input), createBtn);
        }
    }

    function toggleInput(active, ...list) {
        list.forEach(e => {
            if (active) {
                e.setAttribute('disabled', true);
            } else {
                e.removeAttribute('disabled');
            }
        });
    }

    function validateInput(input) {
        let valid = true;
        Object.entries(input).forEach(([k, v]) => {
            if (v === undefined || v.value.length === 0) {
                v.classList.add('inputError');
                valid = false;
            } else {
                v.classList.remove('inputError');
            }
        });

        return valid;
    }

    async function displayBook() {
        btnLoad.setAttribute('disabled', true);

        tableBody.innerHTML = '<tr><td colspan="4">Loading...</td><tr>';

        const books = await api.getBooks();

        tableBody.innerHTML = '';

        books
            .sort((a, b) => a.author.localeCompare(b.author))
            .forEach(b => tableBody.appendChild(renderBook(b)));

        btnLoad.removeAttribute('disabled');
    }

    function renderBook(book) {
        const deleteBtn = el('button', 'Delete');
        deleteBtn.addEventListener('click', deleteBook)
        const editBtn = el('button', 'Edit');
        editBtn.addEventListener('click', toggleEditor)

        const element = el('tr', [
            el('td', book.title),
            el('td', book.author),
            el('td', book.isbn),
            el('td', [
                editBtn,
                deleteBtn
            ])
        ]);

        function toggleEditor() {
            const confirmBtn = el('button', 'Save');
            const cancelBtn = el('button', 'Cancel');

            cancelBtn.addEventListener('click', () => {
                tableBody.replaceChild(element, editor);
            });

            confirmBtn.addEventListener('click', async () => {
                if (validateInput(edit) == false) {
                    alert(`All fields are required!`);
                    return;
                }

                const editedBook = {
                    objectId: book.objectId,
                    title: edit.title.value,
                    author: edit.author.value,
                    isbn: edit.isbn.value
                }

                try {
                    toggleInput(true, ...Object.values(edit), confirmBtn, cancelBtn);
                    const updatedBook = await api.updateBook(editedBook);
                    tableBody.replaceChild(renderBook(updatedBook), editor);
                } catch (err) {
                    alert(err);
                    toggleInput(false, ...Object.values(edit), confirmBtn, cancelBtn);
                }
            });

            const edit = {
                title: el('input', null, { type: 'text', value: book.title }),
                author: el('input', null, { type: 'text', value: book.author }),
                isbn: el('input', null, { type: 'text', value: book.isbn }),
            }

            const editor = el('tr', [
                el('td', edit.title),
                el('td', edit.author),
                el('td', edit.isbn),
                el('td', [
                    confirmBtn,
                    cancelBtn
                ])
            ]);

            tableBody.replaceChild(editor, element);
        }

        async function deleteBook() {
            try {
                deleteBtn.setAttribute('disabled', true);
                deleteBtn.disable = true;
                deleteBtn.textContent = 'Please wait...'
                await api.deleteBook(book.objectId);
                element.remove();
            } catch (err) {
                deleteBtn.removeAttribute('disabled');
                deleteBtn.textContent = 'Delete'
                alert(err);
            }
        }

        return element;
    }
})