"use strict";

function solve() {

    let canCast = (state) => ({
        cast: (spell) => {
            state.mana--;
            console.log(`${state.name} cast ${spell}`);
        }
    })

    let canFight = (state) => ({
        fight: () => {
            state.stamina--;
            console.log(`${state.name} slashes at the foe!`);
        }
    })

    function mage(name) {
        let state = {
            name: name,
            health: 100,
            mana: 100
        }

        return Object.assign(state, canCast(state));
    }

    function fighter(name) {
        let state = {
            name: name,
            health: 100,
            stamina: 100
        }

        return Object.assign(state, canFight(state));
    }

    return { mage: mage, fighter: fighter };
}

//Another solution:
// function solve() {
//     class Mage {
//         constructor(name) {
//             this.name = name;
//             this.health = 100;
//             this.mana = 100;
//         }

//         cast(spell) {
//             this.mana--;
//             console.log(`${this.name} cast ${spell}`);
//         }
//     }

//     class Fighter {
//         constructor(name) {
//             this.name = name;
//             this.health = 100;
//             this.stamina = 100;
//         }

//         fight() {
//             this.stamina--;
//             console.log(`${this.name} slashes at the foe!`);
//         }
//     }

//     function mage(name) {
//         return new Mage(name);
//     }

//     function fighter(name) {
//         return new Fighter(name);
//     }

//     let obj = {
//         mage,
//         fighter
//     }

//     return obj;
// }

//Test
let create = solve();
const scorcher = create.mage("Scorcher");
scorcher.cast("fireball")
scorcher.cast("thunder")
scorcher.cast("light")

const scorcher2 = create.fighter("Scorcher 2");
scorcher2.fight()

console.log(scorcher2.stamina);
console.log(scorcher.mana);