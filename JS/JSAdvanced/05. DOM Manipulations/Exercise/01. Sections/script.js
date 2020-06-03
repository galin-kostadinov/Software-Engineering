function create(words) {
   const content = document.querySelector('#content');

   for (const word of words) {
      let currDiv = document.createElement('div');
      currDiv.addEventListener('click', showTextContent)

      let currP = document.createElement('p');
      currP.style.display = 'none';
      currP.textContent = word;

      currDiv.appendChild(currP);

      content.appendChild(currDiv);
   }

   function showTextContent(ev) {
      ev.target.childNodes[0].style.display = 'block';
   }
}