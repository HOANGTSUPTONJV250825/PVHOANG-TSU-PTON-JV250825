let but = document.getElementById('but');
let but1 = document.getElementById('someBox');
let but2 = document.getElementById('but1');
but1.style.display = 'none';
but.addEventListener('click',function(){
    but1.style.display = 'flex';
    document.body.style.backgroundColor = 'rgba(0,0,0,0.4)';
});
but2.addEventListener('click',function(){
    but1.style.display = 'none';
    document.body.style.backgroundColor = 'aliceblue';
});
