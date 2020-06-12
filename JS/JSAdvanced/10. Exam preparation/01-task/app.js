
function solve() {
   document.querySelector('#add').addEventListener('click', createArticle);
   const sections = document.querySelectorAll('section');

   const addTask = sections[0].querySelector('div:last-child');
   const open = sections.item(1).querySelector('div:last-child');
   const inProgress = sections[2].querySelector('div:last-child');
   const complete = sections[3].querySelector('div:last-child');

   const task = document.querySelector('#task');
   const description = document.querySelector('#description');
   const date = document.querySelector('#date');

   function createArticle(ev) {
      ev.preventDefault(); // stop browser default behavior ->stop submit form
      if (task.value && description.value && date.value) {
         let article = document.createElement('article');
         let h3 = document.createElement('h3');
         h3.textContent = task.value;

         let pDescription = document.createElement('p');
         pDescription.textContent = `Description: ${description.value}`;

         let pDate = document.createElement('p');
         pDate.textContent = `Due Date: ${date.value}`;

         let div = document.createElement('div');
         div.classList.add('flex');

         let startButton = document.createElement('button');
         startButton.classList.add('green');
         startButton.textContent = 'Start';
         startButton.addEventListener("click", start);

         let deleteButton = document.createElement('button');
         deleteButton.classList.add('red');
         deleteButton.textContent = 'Delete';
         deleteButton.addEventListener("click", deleteEl);

         div.appendChild(startButton);
         div.appendChild(deleteButton);

         article.appendChild(h3);
         article.appendChild(pDescription);
         article.appendChild(pDate);
         article.appendChild(div);

         open.appendChild(article);

         task.value = '';
         description.value = '';
         date.value = '';
      }
   }

   function deleteEl(ev) {
      (ev.target.parentNode.parentNode.parentNode).removeChild(ev.target.parentNode.parentNode);
   }

   function finish(ev) {
      let art = ev.target.parentNode.parentNode;
      (ev.target.parentNode.parentNode.parentNode).removeChild(art);

      art.removeChild(art.querySelector('div'));
      complete.appendChild(art);
   }

   function start(ev) {
      let art = ev.target.parentNode.parentNode;
      (ev.target.parentNode.parentNode.parentNode).removeChild(art);

      art.querySelector('div').removeChild(art.querySelector('div > button'));

      let finishButton = document.createElement('button');
      finishButton.classList.add('orange');
      finishButton.textContent = 'Finish';
      finishButton.addEventListener("click", finish);

      art.querySelector('div').appendChild(finishButton);

      inProgress.appendChild(art);
   }

   // function el(type, content, attributes) {
   //    const result = document.createElement(type);

   //    if (attributes !== undefined) {
   //       Object.assign(result, attributes);
   //    }


   //    if (Array.isArray(content)) {
   //       content.forEach(append);
   //    } else {
   //       append(content)
   //    }

   //    function append(node) {
   //       if (typeof node === 'string') {
   //          node = document.createTextNode(node);
   //       }
   //       result.appendChild(node);
   //    }

   //    return result;
   // }
}
