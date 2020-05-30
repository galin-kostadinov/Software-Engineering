"use strict";

function solve(input) {
    let result = {};

    for (const row of input) {
        let [systemName, componentName, subcomponentName] = row.split(/\s*\|\s*/);

        if (!result.hasOwnProperty(systemName)) {
            result[systemName] = {};
        }

        if (!result[systemName].hasOwnProperty(componentName)) {
            result[systemName][componentName] = [];
        }

        result[systemName][componentName].push(subcomponentName);
    }

    let systemNameKeys = Object.keys(result).sort((a, b) => {
        let sort = Object.keys(result[b]).length - Object.keys(result[a]).length;

        if (sort === 0) {
            sort = a.localeCompare(b);
        }

        return sort;
    });

    for (let systemName of systemNameKeys) {
        console.log(systemName);

        let componentNames = Object.keys(result[systemName]).sort((a, b) => {
            return Object.keys(result[systemName][b]).length - Object.keys(result[systemName][a]).length;
        });

        for (let componentName of componentNames) {
            console.log(`|||${componentName}`);

            for (let subcomponentName of result[systemName][componentName]) {
                console.log(`||||||${subcomponentName}`);
            }
        }
    }
}

solve(['SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security']);