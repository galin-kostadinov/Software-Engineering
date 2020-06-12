
class Bank {
    #bankName;
    constructor(bankName) {
        this.#bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer(customer) {
        for (let c of this.allCustomers) {
            if (c.firstName === customer.firstName &&
                c.lastName === customer.lastName &&
                c.personalId === customer.personalId) {

                throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`);
            }
        }

        customer.totalMoney = 0;
        customer.transactions = [];
        this.allCustomers.push(customer);

        return { firstName: customer.firstName, lastName: customer.lastName, personalId: customer.personalId };
    }

    depositMoney(personalId, amount) {
        for (let c of this.allCustomers) {
            if (c.personalId === personalId) {
                c.totalMoney += amount;
                c.transactions.push(`${c.firstName} ${c.lastName} made deposit of ${amount}$!`);

                return `${c.totalMoney}$`;
            }
        }

        throw new Error(`We have no customer with this ID!`);
    }

    withdrawMoney(personalId, amount) {
        for (let c of this.allCustomers) {
            if (c.personalId === personalId) {
                if (c.totalMoney < amount) {
                    throw new Error(`${c.firstName} ${c.lastName} does not have enough money to withdraw that amount!`);
                } else {
                    c.totalMoney -= amount;
                    c.transactions.push(`${c.firstName} ${c.lastName} withdrew ${amount}$!`);
                }

                return `${c.totalMoney}$`;
            }
        }

        throw new Error(`We have no customer with this ID!`);
    }

    customerInfo(personalId) {
        for (let c of this.allCustomers) {
            if (c.personalId === personalId) {
                let result = `Bank name: ${this.#bankName}\nCustomer name: ${c.firstName} ${c.lastName}\nCustomer ID: ${c.personalId}\nTotal Money: ${c.totalMoney}$`

                if (c.transactions.length > 0) {
                    result += `\nTransactions:`;

                    let array = c.transactions;
                    for (let i = array.length - 1; i >= 0; i--) {
                        result += `\n${i + 1}. ${array[i]}`;;
                    }
                }

                return result;
            }
        }

        throw new Error(`We have no customer with this ID!`);
    }
}

// let bank = new Bank("SoftUni Bank");

// console.log(bank.newCustomer({ firstName: "Svetlin", lastName: "Nakov", personalId: 6233267 }));
// console.log(bank.newCustomer({ firstName: "Mihaela", lastName: "Mileva", personalId: 4151596 }));

// bank.depositMoney(6233267, 250);
// console.log(bank.depositMoney(6233267, 250));
// bank.depositMoney(4151596, 555);

// console.log(bank.withdrawMoney(6233267, 125));

// console.log(bank.customerInfo(6233267));

//zero test 2
let name = 'SoftUni Bank';
let bank = new Bank(name);


bank.newCustomer({ firstName: 'Svetlin', lastName: 'Nakov', personalId: 1111111 });
bank.newCustomer({ firstName: 'Svetlin', lastName: 'Nakov', personalId: 1111111 });
// expect(sameCustomer).to.throw(Error, 'Svetlin Nakov is already our customer!');
