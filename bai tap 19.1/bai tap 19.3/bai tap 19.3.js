let logIn = JSON.parse(localStorage.getItem("users"))||[];
let form = document.getElementById("form");
let emailError = document.getElementById("email-error");
let passwordError = document.getElementById("password-error");
let togglePassword = document.getElementById("togglePassword");
togglePassword.addEventListener("click", function () {
    let passwordInput = form.password; 
  if (passwordInput.getAttribute("type") === "password") {
    passwordInput.setAttribute("type", "text");
  } else {
    passwordInput.setAttribute("type", "password");
  }
})
form.addEventListener("submit", function (e) {
    e.preventDefault();
    if (form.email.value === "") {
        emailError.innerText = "please enter email";
        form.addEventListener("input", function () {
            emailError.innerText = "";
        })
    }
    else if (form.password.value === "") {
        passwordError.innerText = "please enter password";
        form.addEventListener("input", function () {
            passwordError.innerText = "";
        })
    }
    else {
        let index = logIn.findIndex(function (e) {
            return e.email === form.email.value && e.password === form.password.value;
        });
        if (index === -1) {
            emailError.innerText = "invalid email or password";
            form.addEventListener("input", function () {
                emailError.innerText = "";
                passwordError.innerText = "";
            })
        }
        else {
            window.location.href = "https://www.google.com/";
        }
    }
})