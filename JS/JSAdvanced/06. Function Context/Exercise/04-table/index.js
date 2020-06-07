function solve() {
   document.querySelector('table > tbody').addEventListener('click', handle);
   let lastTr;

   function handle(ev) {
      let currTr = ev.target.parentElement;
      if (lastTr === currTr) {
         lastTr.style.backgroundColor = '';
         lastTr = '';
         return;
      }

      if (lastTr) {
         lastTr.style.backgroundColor = '';
      }

      lastTr = currTr;
      lastTr.style.backgroundColor = "#413f5e";
   }
}