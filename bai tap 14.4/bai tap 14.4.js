let original = {
    name: "Bob",
    age: 30
};
let copy = JSON.parse(JSON.stringify(original));
copy.name = "Charlie";
console.log(original);
console.log(copy);
