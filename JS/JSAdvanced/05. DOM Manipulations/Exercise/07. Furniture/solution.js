function solve() {
  const buttons = document.querySelectorAll('button');
  const textareaInput = document.querySelector('textarea');
  const textareaOutput = document.querySelectorAll('textarea')[1];
  buttons[0].addEventListener('click', generate);
  buttons[1].addEventListener('click', buy);

  document.querySelector('tbody tr td input').disabled = false;
  const tbody = document.querySelector('tbody');

  function generate(ev) {
    let objs = JSON.parse(textareaInput.value);

    for (let obj of objs) {
      let tr = makeRow(obj);
      tbody.appendChild(tr);
    }
  }

  function makeCell(tagName, attr, val) {
    let td = document.createElement('td');
    let tag = document.createElement(tagName);
    tag[attr] = val;
    td.appendChild(tag);
    return td;
  }

  function makeRow(obj) {
    let tr = document.createElement('tr');

    let img = makeCell('img', 'src', obj.img);
    let name = makeCell('p', 'textContent', obj.name);
    let price = makeCell('p', 'textContent', obj.price);
    let decFactor = makeCell('p', 'textContent', obj.decFactor);
    let mark = makeCell('input', 'type', 'checkbox');

    tr.appendChild(img);
    tr.appendChild(name);
    tr.appendChild(price);
    tr.appendChild(decFactor);
    tr.appendChild(mark);

    return tr;
  }

  function buy(ev) {
    textareaOutput.textContent = '';
    let totalPrice = 0;
    let totalDecFactor = 0;
    const furniture = [];

    let rows = tbody.querySelectorAll('tr');
    for (let row of rows) {
      if (row.querySelector('input').checked) {
        let allP = row.querySelectorAll('td>p');
        furniture.push(allP[0].textContent);
        totalPrice += Number(allP[1].textContent);
        totalDecFactor += Number(allP[2].textContent);
      }
    }

    textareaOutput.textContent = '';
    textareaOutput.value += `Bought furniture: ${furniture.join(', ')}\n`;
    textareaOutput.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    textareaOutput.value += `Average decoration factor: ${totalDecFactor / furniture.length}`;
  }
}