function solve() {
  const answersLi = document.querySelectorAll('.answer-wrap');

  for (let answer of answersLi) {
    answer.addEventListener('click', hendler);
  }

  let index = 1;
  let rightAnswers = 0;

  function hendler(ev) {
    const currAnswer = ev.target.textContent.trim();

    if (index == 1) {
      if (currAnswer === 'onclick') {

        rightAnswers++;
      }
    } else if (index == 2) {
      if (currAnswer === 'JSON.stringify()') {
        rightAnswers++;
      }
    } else if (index == 3) {
      if (currAnswer === 'A programming API for HTML and XML documents') {
        rightAnswers++;
      }
    }

    document.querySelector(`#quizzie section:nth-child(${index + 1})`).style.cssText = `display: none`;

    if (index == 3) {
      console.log(rightAnswers);
      document.getElementById('results').style.display = 'block';
      rightAnswers === 3
        ? document.querySelector('#results h1').textContent = 'You are recognized as top JavaScript fan!'
        : document.querySelector('#results h1').textContent = `You have ${rightAnswers} right answers`

      return;
    }

    index++;
    document.querySelector(`#quizzie section:nth-child(${index + 1})`).classList[0] = '';
    document.querySelector(`#quizzie section:nth-child(${index + 1})`).style.cssText = `display: block`;
  }
}
