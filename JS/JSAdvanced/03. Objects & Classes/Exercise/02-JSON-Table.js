"use-strict";

function solve(input) {
    function parseSpecialHTMLSymbols(el) {
        return el.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }

    let result = '<table>\n';

    for (const jsonObj of input) {
        let el = JSON.parse(jsonObj);
        result += '\t<tr>\n\t\t<td>' + parseSpecialHTMLSymbols(el.name) + '</td>\n\t\t<td>' +
            parseSpecialHTMLSymbols(el.position) + '</td>\n\t\t<td>' +
            Number(el.salary) + '</td>\n\t</tr>\n';
    }

    result += '</table>';
    return result;
}

console.log(solve(['{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}']));