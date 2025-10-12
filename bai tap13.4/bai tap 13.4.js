let chuoi = prompt("nhap vao day so:");
let num = chuoi.split("");
let max = num[0];
for(let i = 1; i < num.length; i++){
if(num[i]>max){
    max = num[i];
}
}
window.alert(+max);
