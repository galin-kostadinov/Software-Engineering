import el from './dom.js';
import * as api from './data.js';

window.addEventListener('load', () => {
    const btnLoad = document.querySelector('#loadStudents');
    btnLoad.addEventListener('click', displayStudents);
    const tableBody = document.querySelector('table tbody');
    const createBtn = document.querySelector('#create');

    const input = {
        id: document.querySelector('#id'),
        firstName: document.querySelector('#firstName'),
        lastName: document.querySelector('#lastName'),
        facultyNumber: document.querySelector('#facultyNumber'),
        grade: document.querySelector('#grade')
    }

    createBtn.addEventListener('click', createBook);

    async function createBook(ev) {
        ev.preventDefault();

        if (validateInput(input) == false) {
            alert(`All fields are required!`);
            return;
        }

        const student = {
            id: Number(input.id.value),
            first_name: input.firstName.value,
            last_name: input.lastName.value,
            faculty_number: input.facultyNumber.value,
            grade: Number(input.grade.value)
        }

        try {
            toggleInput(true, ...Object.values(input), createBtn);
            const created = await api.createStudent(student);
            Object.entries(input).forEach(([k, v]) => v.value = '');
            displayStudents();
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

    async function displayStudents() {
        btnLoad.setAttribute('disabled', true);

        tableBody.innerHTML = '<tr><td colspan="4">Loading...</td><tr>';

        const students = await api.getAllStudents();

        tableBody.innerHTML = '';

        students
            .sort((a, b) => a.id > b.id)
            .forEach(b => tableBody.appendChild(renderStudent(b)));

        btnLoad.removeAttribute('disabled');
    }

    function renderStudent(student) {
        const element = el('tr', [
            el('td', student.id),
            el('td', student.first_name),
            el('td', student.last_name),
            el('td', student.faculty_number),
            el('td', student.grade)
        ]);

        return element;
    }
})