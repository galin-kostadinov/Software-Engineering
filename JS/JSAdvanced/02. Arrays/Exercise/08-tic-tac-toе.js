"use strict";

function ticTacToe(commands = []) {
    const firstPLayer = 'X';
    const secondPLayer = 'O';

    function checkForWinner() {
        let winner = false;
        for (let i = 0; i < 3; i++) {

            if (new Set(board[i]).size === 1 && !(board[i].includes('false'))) {
                winner = board[i][i]
                return winner;
            }

            let vertical = [board[0][i], board[1][i], board[2][i]];
            if (new Set(vertical).size === 1 && !(vertical.includes('false'))) {
                winner = board[i][0]
                return winner;
            }

            let left = [board[0][0], board[1][1], board[2][2]];
            let right = [board[0][2], board[1][1], board[2][0]];
            if ((new Set(left).size === 1 || new Set(right).size === 1) && board[1][1] === secondPLayer) { winner = secondPLayer; return winner }
            if ((new Set(left).size === 1 || new Set(right).size === 1) && board[1][1] === firstPLayer) { winner = firstPLayer; return winner }
        }
        return winner
    }

    let board = [
        ['false', 'false', 'false'],
        ['false', 'false', 'false'],
        ['false', 'false', 'false']]

    let player = firstPLayer;

    for (let move of commands) {
        move = move.split(' ').map(Number);

        if (board[move[0]][move[1]] !== 'false') {
            console.log(`This place is already taken. Please choose another!`);
            continue
        }

        board[move[0]][move[1]] = player;

        player === firstPLayer ? player = secondPLayer : player = firstPLayer;

        let winner = checkForWinner();
        if (winner) {
            console.log(`Player ${winner} wins!`);
            break;
        }

        if (!(board.flat().includes('false'))) {
            console.log('The game ended! Nobody wins :(');
            break;
        }
    }

    for (let row of board) {
        console.log(row.join('\t'))
    }
}