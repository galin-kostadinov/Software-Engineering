const appId = '2D76FEF1-96F4-7C7C-FFBD-F1D6603E1A00';
const apiKey = '9A1A04EE-A230-4533-82E1-FAAFF165F9A8';

function url(endpoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/data/${endpoint}`;
}

export async function getAllStudents() {
    const response = await fetch(url('students'));
    const data = await response.json();
    return data;
}

export async function createStudent(book) {
    const response = await fetch(url('students'), {
        method: 'POST',
        body: JSON.stringify(book),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const data = await response.json();
    return data;
}