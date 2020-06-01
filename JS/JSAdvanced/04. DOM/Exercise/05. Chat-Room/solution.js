function solve() {
   document.querySelector("#send").addEventListener('click', chat);

   function chat() {
      let currentMessageArea = document.querySelector("#chat_input")
      const currentMessage = currentMessageArea.value;

      if (currentMessage !== '') {
         let newDiv = document.createElement("div");
         newDiv.classList.add("message");
         newDiv.classList.add("my-message");
         newDiv.textContent = currentMessage;

         document.querySelector("#chat_messages").appendChild(newDiv);

         currentMessageArea.value = '';
      }
   }
}


