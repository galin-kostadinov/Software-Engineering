"use strict";

function solve(tickets, criterion) {
    class Ticket {
        constructor(row) {
            let args = row.split(/\|/);
            this.destination = args[0];
            this.price = Number(args[1]);
            this.status = args[2];
        }
    }

    return tickets.map(t => new Ticket(t)).sort(comparator);

    function comparator(a, b) {
        try {
            return (a[criterion]).localeCompare(b[criterion]);
        } catch (error) {
            return a.price - b.price;
        }
    }
}

console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'));