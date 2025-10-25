let users = JSON.parse(localStorage.getItem("users")) || [];
let form = document.getElementById("form");
let emailError = document.getElementById("error-email");
let passwordError = document.getElementById("error-password");
let confirmError = document.getElementById("error-confirm");
form.addEventListener("submit",function(e){
    e.preventDefault();
if (form.email.value === ""){
    emailError.innerText = "vui long nhap password";
    form.email.value = "";
    form.addEventListener("input", function(){
        emailError.innerText = "";
    })
}
else if(form.password.value === ""){
    passwordError.innerText = "vui long nhap password";
    form.password.value = "";
    form.addEventListener("input", function(){
        passwordError.innerText = "";
        confirmError.innerText = "";
    })
}
else if(form.confirm.value === "" || form.confirm.value !== form.password.value){
    confirmError.innerText = "vui long nhap lai password";
    form.confirm.value = "";
    form.addEventListener("input", function(){
        confirmError.innerText = "";
        passwordError.innerText = "";
    })
}
else {
    let index = users.findIndex(function(e){
        return e.email === form.email.value;
    });
    if( index === -1){
        let newUser = {
            email: form.email.value,
            password: form.password.value
        }
        users.push(newUser);
        localStorage.setItem("users", JSON.stringify(users));
        form.email.value = "";
        form.password.value = "";
        form.confirm.value = "";
    }
    else{
        emailError.innerText = "email da ton tai";
        form.email.value = "";
        form.password.value = "";
        form.confirm.value = "";
        form.addEventListener("input", function(){
        emailError.innerText = "";
    })
    }
}
});