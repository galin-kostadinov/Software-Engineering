function solve() {
  let text = document.getElementById('input').innerHTML.split('.').map(el => el.trim() + '.').filter(el => el !== '.');

  let output = document.getElementById('output');

  let resultText = [];
  for (let i = 0; i < text.length; i++) {
    if (i === 0 || i % 3 === 0) {
      resultText.push(text[i]);
      continue;
    }

    let temp = resultText[resultText.length - 1] + ' ' + text[i];
    resultText[resultText.length - 1] = temp;
  }

  for (let singleParagraph of resultText) {
    let p = document.createElement('p');
    p.textContent = singleParagraph;
    output.appendChild(p);
  }
}