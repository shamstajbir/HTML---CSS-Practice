// Selecting elements from the DOM
const plusBtn = document.querySelector(".plus");
const plusBtn2 = document.querySelector(".plus2");
const numBtn = document.querySelector(".num");
const numBtn2 = document.querySelector(".num2");
const minusBtn = document.querySelector(".minus");   
const minusBtn2 = document.querySelector(".minus2");  

const roomCntBtn = document.querySelector(".room-cnt");   
const roomCntBtn2 = document.querySelector(".room-cnt2"); 
const thanksCntBtn = document.querySelector(".thanks-cnt");   
const thanksCntBtn2 = document.querySelector(".thanks-cnt2"); 

const signBtn = document.querySelector(".signup-button");   
const signBtn2 = document.querySelector(".signup-button-2"); 

const thanksMes = document.querySelector(".thanks");   
const thanksMes2 = document.querySelector(".thanks2");   

// Initializing counters and totals
let cnt = 1, total;
let cnt2 = 1, total2;

// Event handlers for the first set of buttons
plusBtn.addEventListener("click", function (){
    cnt++;
    total = cnt * 199;
    numBtn.innerText = "$" + total;
    roomCntBtn.innerText = cnt;
    thanksCntBtn.innerText = cnt;
});

minusBtn.addEventListener("click", function (){
    if (cnt > 1)
        cnt--;

    total = cnt * 199;
    numBtn.innerText = "$" + total;
    roomCntBtn.innerText = cnt;
    thanksCntBtn.innerText = cnt;
});

// Event handlers for the second set of buttons
plusBtn2.addEventListener("click", function (){
    cnt2++;
    total2 = cnt2 * 249;
    numBtn2.innerText = "$" + total2;
    roomCntBtn2.innerText = cnt2;
    thanksCntBtn2.innerText = cnt2;
});

minusBtn2.addEventListener("click", function (){
    if (cnt2 > 1)
        cnt2--;

    total2 = cnt2 * 249;
    numBtn2.innerText = "$" + total2;
    roomCntBtn2.innerText = cnt2;
    thanksCntBtn2.innerText = cnt2;
});

// Event handlers for signup buttons to display a thank you message
signBtn.addEventListener("click", function (){
    thanksMes.innerText = "Thank you for choosing " + cnt + " room";
});

signBtn2.addEventListener("click", function (){
    thanksMes2.innerText = "Thank you for choosing " + cnt2 + " room";
});
