"use strict";

function solve(arr) {
    let collection = [];

    const innerCommands = {
        add: function (collection, str) {
            return [...collection, str];
        },
        remove: function (collection, str) {
            return collection.filter(x => x !== str);
        },
        print: function (collection) {
            console.log(collection.join(','));
            return collection;
        }
    }

    return arr.map(el => {
        const [command, element] = el.split(' ');
        collection = innerCommands[command](collection, element);
    });
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);