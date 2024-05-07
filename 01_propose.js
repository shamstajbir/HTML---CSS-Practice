document.addEventListener('DOMContentLoaded', function() {
    const noButton = document.getElementById('target'); 
    const yesButton = document.getElementById('yes'); 
    const container = document.getElementById('container'); 
    
    
    noButton.addEventListener('mouseover', function() {
        const containerWidth = container.clientWidth; 
        const containerHeight = container.clientHeight; 
        
       
        const randomX = Math.random() * (containerWidth - noButton.clientWidth);
        const randomY = Math.random() * (containerHeight - noButton.clientHeight);
        
        
        noButton.style.left = `${randomX}px`;
        noButton.style.top = `${randomY}px`;
    });

    
    yesButton.addEventListener('click', function() {
        alert('Yay,Love you too Babes🥰'); 
    });
});
