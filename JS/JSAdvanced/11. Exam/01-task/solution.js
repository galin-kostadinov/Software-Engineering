function solve() {
    document.querySelector('#container button').addEventListener('click', add);
    let containerInputs = document.querySelectorAll('#container input');

    let name = containerInputs[0];
    let age = containerInputs[1];
    let kind = containerInputs[2];
    let currentOwner = containerInputs[3];


    let adoptionUl = document.querySelector('#adoption > ul');
    let adoptedUl = document.querySelector('#adopted > ul');

    function add(ev) {
        ev.preventDefault();
        if (name.value && age.value && !isNaN(age.value) && kind.value && currentOwner.value) {
            let li = document.createElement('li');
            let p = document.createElement('p');

            let strongName = document.createElement('strong');
            strongName.textContent = name.value;

            let strongAge = document.createElement('strong');
            strongAge.textContent = age.value;

            let strongKind = document.createElement('strong');
            strongKind.textContent = kind.value;

            p.appendChild(strongName);

            let  t1= document.createTextNode(" is a ");
           
            p.appendChild(t1);

            p.appendChild(strongAge);


            let  t2= document.createTextNode(" year old ");
        
            p.appendChild(t2);

            p.appendChild(strongKind);

            li.appendChild(p);

            let spanOwner = document.createElement('span');
            spanOwner.textContent = `Owner: ${currentOwner.value}`;

            li.appendChild(spanOwner);

            let button = document.createElement('button');
            button.textContent = `Contact with owner`;

            button.addEventListener('click', contactWithOwner);

            li.appendChild(button);

            adoptionUl.appendChild(li);

            name.value = '';
            age.value = '';
            kind.value = '';
            currentOwner.value = '';
        }
    }

    function contactWithOwner(ev) {
        let li = ev.target.parentNode;
        li.removeChild(ev.target);

        let div = document.createElement('div');

        let input = document.createElement('input');
        input.setAttribute("placeholder", "Enter your names");

        let button = document.createElement('button');
        button.textContent = `Yes! I take it!`;

        button.addEventListener('click', take);

        div.appendChild(input);
        div.appendChild(button);

        li.appendChild(div);
    }

    function take(ev) {
        let div = ev.target.parentNode;
        let input = div.querySelector('input');

        if (input.value) {
            let li = div.parentNode;
            li.removeChild(div);

            let button = document.createElement('button');
            button.textContent = `Checked`;

            button.addEventListener('click', checked);

            li.appendChild(button);

            let liParent = li.parentNode;

            li.querySelector('span').textContent = `New Owner: ${input.value}`;

            adoptedUl.appendChild(li);
            liParent.removeChild(li);
        }
    }

    function checked(ev) {
        let ul = ev.target.parentNode.parentNode;
        ul.removeChild(ev.target.parentNode);
    }
}

