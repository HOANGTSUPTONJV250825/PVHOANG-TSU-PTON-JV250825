let matrix = [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    0
];
let tim = +prompt("nhap vao so");
let hasNumber = false;
for (let i = 0; i < matrix.length; i++) {
  if (matrix[i] === tim) {
    hasNumber = true;
  }
}
if (hasNumber) {
  alert('Bingo');
} else {
  alert('Chúc bạn may mắn lần sau');
}