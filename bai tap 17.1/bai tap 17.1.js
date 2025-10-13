let text = document.querySelector('h1');
console.log(text);
const button1 = document.getElementById('but1');
button1.addEventListener('click', function(){
   text.style.display = 'none';
   
});
const button2 = document.getElementById('but2');
button2.addEventListener('click', function(){
    text.style.display = 'block';
});