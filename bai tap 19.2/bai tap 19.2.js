
let courses = JSON.parse(localStorage.getItem("courses")) || [];
let form = document.getElementById("form");
let tbody = document.getElementById("tbody");
let editIndex = null;
function renderTable() {
  tbody.innerHTML = "";
  courses.forEach((course, i) => {
    let tr = document.createElement("tr");
    tr.innerHTML = `
      <td>${+i+1}</td>
      <td>${course.content}</td>
      <td>${course.dueDate}</td>
      <td>${course.status}</td>
      <td>${course.assignedTo}</td>
      <td class="op">
        <button class="but1" data-index="${i}">Sửa</button>
        <button class="but2" data-index="${i}">Xóa</button>
      </td>`;
    tbody.appendChild(tr);
  });
  attachButtonEvents();
}

renderTable();
form.addEventListener("submit", function (e) {
  e.preventDefault();
  let newCourse = {
    content: form.content.value,
    dueDate: form.date.value,
    status: form.status.value,
    assignedTo: form.username.value,
  };

  if (editIndex === null) {
    courses.push(newCourse);
  } else {
    courses[editIndex] = newCourse;
    courses.id =editIndex +1;
    editIndex = null;
  }

  localStorage.setItem("courses", JSON.stringify(courses));
  renderTable();
  form.reset();
});
function attachButtonEvents() {
  const setButtons = document.querySelectorAll(".but1");
  const delButtons = document.querySelectorAll(".but2");

  setButtons.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      const i = e.target.dataset.index;
      const c = courses[i];
      editIndex = i;
      form.content.value = c.content;
      form.date.value = c.dueDate;
      form.status.value = c.status;
      form.username.value = c.assignedTo;
    });
  });

  delButtons.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      const i = e.target.dataset.index;
      courses.splice(i, 1);
      localStorage.setItem("courses", JSON.stringify(courses));
      renderTable();
    });
  });
}