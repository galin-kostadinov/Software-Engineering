function solve() {
   const imgs = document.querySelectorAll('img');
   for (let img of imgs) {
      img.addEventListener('click', addCard);
   }

   const history = document.querySelector('#history');
   const result = document.querySelectorAll('#result span');

   let leftCardImg;
   let rightCardImg;
   let leftCard = -1;
   let rightCard = -1;

   function addCard(ev) {
      ev.target.removeEventListener('click', addCard);

      const parentId = ev.target.parentElement['id'];
      const cardNumber = Number(ev.target.name);

      if (parentId == 'player1Div' && leftCard == -1) {
         leftCard = cardNumber;
         ev.target['src'] = "images/whiteCard.jpg";
         result[0].textContent = leftCard;
         leftCardImg = ev.target;
      } else if (parentId == 'player2Div' && rightCard == -1) {
         rightCard = cardNumber;
         ev.target['src'] = "images/whiteCard.jpg";
         result[2].textContent = rightCard;
         rightCardImg = ev.target;
      }

      if (leftCard !== -1 && rightCard !== -1) {
         if (leftCard < rightCard) {
            leftCardImg.style.border = '2px solid red';
            rightCardImg.style.border = '2px solid green';
         } else if (leftCard > rightCard) {
            leftCardImg.style.border = '2px solid green';
            rightCardImg.style.border = '2px solid red';
         }

         history.textContent += `[${leftCard} vs ${rightCard}] `
         leftCard = -1;
         rightCard = -1;

         result[0].textContent = '';
         result[2].textContent = '';
      }
   }
}