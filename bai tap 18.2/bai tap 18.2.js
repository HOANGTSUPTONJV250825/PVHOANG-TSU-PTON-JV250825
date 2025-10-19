/*let products = [
    {id:1, name: 'Milk', count: 100},
    {id:2, name: 'Orange', count: 100},
    {id:3, name: 'Butter', count: 100},
];
products.push({id:4, name: 'Fruit', count: 100},);
products.splice(1,1);
products[2].id = 0;
for(let index in products){
    if(products[index].name === 'Butter'){
        console.log(products);
    }else{
        console.log(`khong co du lieu ban tim kiem`);
    }
}*/


let course = [
    {
        name: "HTML",
        Complete: "false"
    },
    {
        name: "CSS",
        Complete: "false"
    },
    {
        name: "Basic of javascript",
        Complete: "false"
    },
    {
        name: "Node package Manager (npm)",
        Complete: "false"
    },
    {
        name: "Gib",
        Complete: "false"
    },
];
function displayCourse() {
    for (let index in course) {
        console.log(`${+index + 1}.${course[index].name}`);
        console.log(`Complete: ${course[index].Complete}`);
    }
}
displayCourse();
let menu = `
----------------MENU--------------
 C. nhap vao khoa hoc moi va trang thai hoan thanh
 R. in ra toan bo khoa hoc
 U. nhap vi tri update khoa hoc. nhap vao ten muon update va trang thai moi.
 D. vi tri khoa hoc muon xoa
 E. Dừng chương trình (Thoát)`;
while (true) {
    let input = prompt(menu);
    if (input === "C") {
        let newCourse = prompt("nhap vao khoa hoc moi:");
        let newStatus = prompt("nhap vao trang thai hoan thanh:")
        course.push({ name: newCourse, Complete: newStatus })
        displayCourse();
    }
    else if (input === "R") {
        displayCourse();
    }
    else if (input === "U") {
        let location = +prompt('nhap vao vi tri muon update khoa hoc:');
        let index = course.findIndex(function (el, i) {
            return i + 1 === location;
        });
        if (index === -1) {
            console.log('gia tri khong hop le');
        } else {
            let newUpdate = prompt("nhap vao khoa hoc update:");
            let newStatus = prompt("nhap vao trang thai hoan thanh:");
            course[index] = { name: newUpdate, Complete: newStatus };
            displayCourse();
        }
    }
    else if (input === "D") {
        let delLocation = +prompt("nhap vao vi tri khoa hoc muon xoa:");
        let index = course.findIndex(function (el, i) {
            return i + 1 === delLocation;
        });
        if (index === -1) {
            console.log('gia tri khong hop le');
        }
        else {
            delete course[index];
            displayCourse();
        }
    }
    else if (input === "E") {
        break;
    }
    else {
        console.log("thong tin khong hop le");
    }
}