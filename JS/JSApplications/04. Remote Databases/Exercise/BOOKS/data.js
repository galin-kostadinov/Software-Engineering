const appId = '2D76FEF1-96F4-7C7C-FFBD-F1D6603E1A00';
const apiKey = '9A1A04EE-A230-4533-82E1-FAAFF165F9A8';

function url(endpoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/data/${endpoint}`;
}

export async function getBooks() {
    const response = await fetch(url('books'));
    const data = await response.json();
    return data;
}

export async function createBook(book) {
    const response = await fetch(url('books'), {
        method: 'POST',
        body: JSON.stringify(book),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const data = await response.json();
    return data;
}

export async function updateBook(book) {
    const id = book.objectId;
    const response = await fetch(url('books/' + id), {
        method: 'PUT',
        body: JSON.stringify(book),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const data = await response.json();
    return data;
}

export async function deleteBook(id) {
    const response = await fetch(url('books/' + id), {
        method: 'DELETE'
    });

    const data = await response.json();
    return data;
}