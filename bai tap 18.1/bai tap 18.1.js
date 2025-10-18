/*let infor = {
    id: 1,
    name: "Nguyen Van A",
    age: 20,
    address: "Ha Noi",
    phone: "016789752"
}
function information(){
    console.log(infor);
}
information();
*/
let student = {
    id: 1,
    name: "Nguyen Van A",
    gender: "nam",
    age: 20,
    mark: 8,
}
let names = prompt("hay nhap vao ten:");
let gender = prompt(`hay nhap gioi tinh cua ${names}: `);
let age = +prompt(`hay nhap vao tuoi cua ${names}:`);
let mark = +prompt(`hay nhap vao diem cua ${names}:`);
let newStudent = {
    id: Math.random(),
    name: names,
    age: age,
    mark: mark
}
let students = [student,newStudent];
let max = students[0].mark;
//console.log(students[1]);
for(let i = 1;i < students.length; i++ ){
    //console.log(students[0].mark);
    
    if(students[i].mark > max){
        max = students[i];
        console.log(max);
    }else{console.log(students[0]);}
    
}
