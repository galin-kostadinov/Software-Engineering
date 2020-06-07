"use strict";

function result() {
    function init(selector1, selector2, resultSelector) {
        this.inputTagNum1 = document.querySelector(selector1);
        this.inputTagNum2 = document.querySelector(selector2);
        this.inputTagResult = document.querySelector(resultSelector);
    }

    function add() {
        this.inputTagResult.value = Number(this.inputTagNum1.value) + Number(this.inputTagNum2.value);
    }

    function subtract() {
        this.inputTagResult.value = Number(this.inputTagNum1.value) - Number(this.inputTagNum2.value);
    }

    let obj = {
        init,
        add,
        subtract
    };

    obj.init('#num1', '#num2', '#result');

    document.querySelector('#sumButton').addEventListener('click', add.bind(obj));
    document.querySelector('#subtractButton').addEventListener('click', subtract.bind(obj));

    return obj;
}

solve();