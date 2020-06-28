"use strict";

class VeterinaryClinic {
    constructor(clinicName, capacity) {
        this.clinicName = clinicName;
        this.capacity = capacity;
        this.clients = [];
        this._totalProfit = 0;
        this._currentWorkload = 0;
    }

    //TODO properties;

    newCustomer(ownerName, petName, kind, procedures) {
        if (this._currentWorkload === this.capacity) {
            throw new Error("Sorry, we are not able to accept more patients!");
        }

        let client = this.clients.find(obj => obj.ownerName === ownerName);

        let currentPet = undefined;

        if (client !== undefined) {
            currentPet = client.pets.find(obj => obj.petName === petName);
            //TODO check kind
            if (currentPet !== undefined && currentPet.procedures.length > 0) {
                let message = `This pet is already registered under ${ownerName} name! ${petName} is on our lists, waiting for ${currentPet.procedures.join(', ')}.`;
                throw new Error(message);
            }
        }

        if (client === undefined) {
            client = {
                ownerName: ownerName,
                pets: []
            }

            this.clients.push(client);
        }

        if (currentPet === undefined) {
            let currentPet = {
                petName: petName,
                kind: kind.toLowerCase(),
                procedures: procedures
            };

            client.pets.push(currentPet);
        } else if (currentPet.procedures.length == 0) {
            currentPet.procedures = procedures;
        }

        this._currentWorkload++;
        return `Welcome ${petName}!`;
    }

    onLeaving(ownerName, petName) {
        let client = this.clients.find(obj => obj.ownerName === ownerName);

        if (client === undefined) {
            throw new Error("Sorry, there is no such client!");
        }

        let currentPet = client.pets.find(obj => obj.petName === petName);

        if (currentPet === undefined || currentPet.procedures.length === 0) {
            throw new Error(`Sorry, there are no procedures for ${petName}!`);
        }

        this._totalProfit += currentPet.procedures.length * 500;
        currentPet.procedures.splice(0, currentPet.procedures.length);
        //currentPet.procedures = [];
        this._currentWorkload--;

        return `Goodbye ${petName}. Stay safe!`;
    }

    toString() {
        let percentage = Math.floor(100 * this._currentWorkload / this.capacity);
        let result = `${this.clinicName} is ${percentage}% busy today!`;
        result += `\nTotal profit: ${this._totalProfit.toFixed(2)}$`;

        this.clients.sort((a, b) => {
            if (a.ownerName < b.ownerName) {
                return -1;
            }
            if (a.ownerName > b.ownerName) {
                return 1;
            }

            return 0;
        });

        for (let client of this.clients) {

            client.pets.sort((a, b) => {
                if (a.petName < b.petName) {
                    return -1;
                }
                if (a.petName > b.petName) {
                    return 1;
                }

                return 0;
            });

            result += `\n${client.ownerName} with:`;

            for (let pet of client.pets) {
                result += `\n---${pet.petName} - a ${pet.kind} that needs: ${pet.procedures.join(', ')}`;
            }
        }

        return result;
    }

}



let clinic = new VeterinaryClinic('SoftCare', 10);
console.log(clinic.newCustomer('Jim Jones', 'Tom', 'Cat', ['A154B', '2C32B', '12CDB']));
console.log(clinic.newCustomer('Anna Morgan', 'Max', 'Dog', ['SK456', 'DFG45', 'KS456']));
console.log(clinic.newCustomer('Jim Jones', 'Tiny', 'Cat', ['A154B']));
console.log(clinic.onLeaving('Jim Jones', 'Tiny'));
console.log(clinic.newCustomer('Jim Jones', 'Tiny', 'Cat', ['A154Ba']));
console.log(clinic.toString());
clinic.newCustomer('Jim Jones', 'Sara', 'Dog', ['A154B']);
console.log(clinic.toString());