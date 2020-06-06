function solution() {
    const microelements = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    const recipes = {
        apple: {
            carbohydrate: 1,
            flavour: 2
        },
        lemonade: {
            carbohydrate: 10,
            flavour: 20
        },
        burger: {
            carbohydrate: 5,
            fat: 7,
            flavour: 3
        },
        eggs: {
            protein: 5,
            fat: 1,
            flavour: 1
        },
        turkey: {
            protein: 10,
            carbohydrate: 10,
            fat: 10,
            flavour: 10
        }
    }

    function restock(microelement, quantity) {
        microelements[microelement] += Number(quantity);
        return 'Success';
    }

    function prepare(recipe, quantity) {
        let error = checkStock(recipe, quantity);

        if (error) {
            return `Error: not enough ${error} in stock`;
        }

        reduceMicroelements(recipe, quantity);

        return 'Success';
    }

    function reduceMicroelements(recipe, quantity) {
        let currRecipe = recipes[recipe];

        for (let el of Object.keys(currRecipe)) {
            microelements[el] -= currRecipe[el] * quantity;
        }
    }

    function checkStock(recipe, quantity) {
        let currRecipe = recipes[recipe];

        for (let el of Object.keys(currRecipe)) {
            if (microelements[el] < currRecipe[el] * quantity) {
                return el;
            }
        }

        return '';
    }

    function report() {
        return `protein=${microelements.protein} carbohydrate=${microelements.carbohydrate} fat=${microelements.fat} flavour=${microelements.flavour}`;
    }

    return function (str) {
        let arr = str.split(/\s+/);

        if (arr[0] === 'restock') {
            return restock(arr[1], arr[2]);
        } else if (arr[0] === 'prepare') {
            return prepare(arr[1], arr[2]);
        } else if (arr[0] === 'report') {
            return report();
        } else {
            return 'Error: Command does not exists!';
        }
    }
}

let manager = solution();

//Test 1
// manager("restock carbohydrate 10");
// manager("restock flavour 10");
// manager("prepare apple 1");
// manager("restock fat 10");
// manager("prepare burger 1");
// manager("report");

//Test 2
manager("prepare turkey 1");
manager("restock protein 10");
manager("prepare turkey 1");
manager("restock carbohydrate 10");
manager("prepare turkey 1");
manager("restock fat 10");
manager("prepare turkey 1");
manager("restock flavour 10");
manager("prepare turkey 1");
manager("report");