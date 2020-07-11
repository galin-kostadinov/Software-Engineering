function el(type, content, attributes) {
    const result = document.createElement(type);

    if (attributes != undefined) {
        Object.assign(result, attributes);
    }

    if (Array.isArray(content)) {
        content.forEach(append);
    } else {
        append(content);
    }

    function append(node) {
        if (typeof node === 'string' || typeof node === 'number') {
            node = document.createTextNode(node);
        }
        result.appendChild(node);
    }

    return result;
}

let divEl = el('div', [
    el('span', symbols[condition], { className: 'condition symbol' }),
    el('span', [
        el('span', location, { className: 'forecast-data' }),
        el('span', `${low}&#176/${high}&#176`, { className: 'forecast-data' }),
        el('span', condition, { className: 'forecast-data' })
    ], { className: 'condition' })
]);