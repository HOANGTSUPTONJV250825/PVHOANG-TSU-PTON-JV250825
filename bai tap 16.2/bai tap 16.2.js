

function minNum(arr){
    let min = Infinity;
    for (let i = 0; i < arr.length; i++) {
    if (min > arr[i]) {
      min = arr[i];
    }
  }
  return min;
}
const arr1 = [3,5,1,8,-3,7,8];
const arr2 = [7,12,6,9,20,56,89];
const arr3 = [];
const arr4 = [0,0,0,0,0,0,0];
let result1 = minNum(arr1);
console.log(result1);
let result2 = minNum(arr2);
console.log(result2);
let result3 = minNum(arr3);
console.log(result3);
let result4 = minNum(arr4);
console.log(result4);