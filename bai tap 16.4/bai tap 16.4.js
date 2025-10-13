function isEven(a){
    return a % 2 === 0;
};
let num = +prompt("nhap vao so");
let result = isEven(num);
window.alert(result);