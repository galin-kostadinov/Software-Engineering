function deleteByEmail() {
    const inputEmail = document.querySelector("input[name='email']");
    const inputValue = inputEmail.value;

    const resultDiv = document.querySelector('#result');

    const tableRows = document.querySelectorAll('#customers > tbody tr');

    for (let row of tableRows) {
        if (row.querySelectorAll('td')[1].textContent === inputValue) {
            row.remove();

            resultDiv.textContent = 'Deleted.';
            return;
        }
    }

    resultDiv.textContent = 'Not found.';
}