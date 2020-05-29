"use-strict";

function solve(json) {
    function parseSpecialHTMLSymbols(el) {
        return el.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }

    let obj = JSON.parse(json);
    let result = '<table>\n';

    let headers = Array.from(new Set(obj.map(o => Object.keys(o)).flat()));

    result += '\t<tr>';
    headers.forEach(el => result += '<th>' + el + '</th>');
    result += '</tr>\n';

    result = obj.reduce((acc, el) => {
        let innerResult = '\t<tr>';
        headers.forEach(h => innerResult += '<td>' + (el[h] !== undefined ? (typeof el[h] === 'string' || el[h] instanceof String ? parseSpecialHTMLSymbols(el[h]) : el[h]) : '') + '</td>');
        innerResult += '</tr>\n';
        return acc + innerResult;
    }, result);

    result += '</table>';
    return result;
}

console.log(solve(['[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]']));