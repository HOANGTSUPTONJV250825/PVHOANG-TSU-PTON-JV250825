let i = +prompt('nhap vao nam');

if(i % 4 == 0 && i % 100 !== 0){
   console.log('năm nhuận');
}
else if(i % 100 == 0 && i % 400 == 0){
    console.log('năm nhuận');
}
else{
    console.log('không phải năm nhuận');
}
