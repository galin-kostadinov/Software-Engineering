function solve() {
   const result = document.querySelector('#result');

   document.querySelector('#searchBtn').addEventListener('click', search);
   let input = document.querySelector('#searchField');

   const allRows = document.querySelectorAll('tbody tr')

   function search(ev) {
      for (let row of allRows) {
         row.classList.remove('select');
      }

      let value = input.value;

      for (let row of allRows) {
         if (row.textContent.includes(value)) {
            row.classList.add('select');
         }
      }

      input.value = '';
   }
}