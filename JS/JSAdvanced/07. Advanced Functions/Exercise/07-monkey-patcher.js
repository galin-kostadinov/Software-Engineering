"use strict";

function solution(command) {
    let balance = this.upvotes - this.downvotes;
    let totalVotes = this.upvotes + this.downvotes;

    let commands = {
        score: () => {
            let up = this.upvotes;
            let down = this.downvotes;

            if (totalVotes > 50) {
                const additonalVal = totalVotes < 50 ? 0 : Math.ceil(Math.max(up, down) * 0.25);

                up += additonalVal;
                down += additonalVal;
            }

            return [up, down, balance, getRating.call(this)];

            function getRating() {
                if (totalVotes < 10) {
                    return 'new';
                }
                if (this.upvotes > (this.upvotes + this.downvotes) * 0.66) {
                    return 'hot';
                } else if (balance >= 0 && (this.upvotes > 100 || this.downvotes > 100)) {
                    return 'controversial';
                } else if (this.upvotes < this.downvotes) {
                    return "unpopular";
                } else {
                    return 'new';
                }
            }
        },
        upvote: () => this.upvotes++,
        downvote: () => this.downvotes++,
    }

    return commands[command]();
}

let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};

solution.call(post, 'upvote');