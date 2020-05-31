function solve() {
  [...document.querySelectorAll('.link-1 a')].forEach(e => e.addEventListener("click", callChangeVisited));

  function callChangeVisited(event) {
    const paragraph = event.currentTarget.nextElementSibling;
    const arr = paragraph.textContent.split(/\s+/);
    arr[1] = Number(arr[1]) + 1;
    paragraph.textContent = arr.join(' ');
  }
}