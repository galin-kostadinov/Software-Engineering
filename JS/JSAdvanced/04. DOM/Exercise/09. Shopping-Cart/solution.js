function solve() {
   const addButtons = document.querySelectorAll('.product-add button');
   const checkoutButton = document.querySelector('button.checkout');
   const shoppingCart = document.querySelector('.shopping-cart textarea');
   let totalPrice = 0;
   const products = new Set();
   let isCheckout = false;
   
   for (let button of addButtons) {
      button.addEventListener('click', addInCart);
   }

   checkoutButton.addEventListener('click', checkout);

   function addInCart(ev) {
      if (isCheckout) {
         return;
      }
      const productDiv = ev.target.parentElement.parentElement;
      let productTitle = productDiv.querySelector('.product-title').textContent;
      let productPrice = productDiv.querySelector('.product-line-price').textContent;
      totalPrice += Number(productPrice);
      products.add(productTitle);

      shoppingCart.value += `Added ${productTitle} for ${productPrice} to the cart.\n`;
   }

   function checkout(ev) {
      if (isCheckout) {
         return;
      }

      shoppingCart.value += `You bought ${Array.from(products).join(', ')} for ${totalPrice.toFixed(2)}.\n`;

      isCheckout = true;
   }
}
