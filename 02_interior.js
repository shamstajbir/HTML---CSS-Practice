// JavaScript for package price calculation and signup button functionality
document.addEventListener('DOMContentLoaded', () => {
    const updatePrice = (selector, price, count) => {
      document.querySelector(selector).innerText = `$${price * count}`;
    };
  
    const updateRoomCount = (selector, count) => {
      document.querySelector(selector).innerText = count;
    };
  
    const adjustPrice = (calcClass, numClass, countClass, basePrice) => {
      let count = 1;
      document.querySelector(`${calcClass} .plus`).addEventListener('click', () => {
        count++;
        updatePrice(numClass, basePrice, count);
        updateRoomCount(countClass, count);
      });
      document.querySelector(`${calcClass} .minus`).addEventListener('click', () => {
        if (count > 1) {
          count--;
          updatePrice(numClass, basePrice, count);
          updateRoomCount(countClass, count);
        }
      });
    };
  
    adjustPrice('.wrapper', '.num', '.room-cnt', 199);
    adjustPrice('.wrapper2', '.num2', '.room-cnt2', 249);
  
    const signupButtonHandler = (buttonClass, messageClass) => {
      document.querySelector(buttonClass).addEventListener('click', () => {
        document.querySelector(messageClass).innerText = 'Thanks for signing up!';
      });
    };
  
    signupButtonHandler('.signup-button', '.thanks');
    signupButtonHandler('.signup-button-2', '.thanks2');
  });
  