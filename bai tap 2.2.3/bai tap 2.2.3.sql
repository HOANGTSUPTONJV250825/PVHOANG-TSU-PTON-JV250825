CREATE DATABASE companyDB;

USE companyDB;

CREATE TABLE departments (
departmentsID INT PRIMARY KEY,
departmentsName VARCHAR(100)
);

CREATE TABLE employees (
employeesID INT PRIMARY KEY,
employeesName VARCHAR(100),
departmentsID INT,
salary INT,
CONSTRAINT fk_departments_name
     FOREIGN KEY (departmentsID)
     REFERENCES departments(departmentsID)
);

INSERT INTO departments (departmentsID, departmentsName)
VALUES
(1, 'Human Resources'),
(2, 'IT'),
(3, 'Finance');

INSERT INTO employees (employeesID, employeesName, departmentsID, salary)
VALUES
(101, 'Alice Nguyen', 1, 5000),
(102, 'Bob Tran', 2, 4500),
(103, 'Charlie Le', 2, 4800),
(104, 'David Pham', 3, 5200),
(105, 'Eva Hoang', 1, 4700);

SELECT e.employeesID, e.employeesName, d.departmentsName, e.salary
FROM employees e
JOIN departments d ON e.departmentsID = d.departmentsID;

UPDATE employees
SET salary = salary * 1.10
WHERE employeesID = 102;

SELECT * FROM employees
WHERE salary < 4800;




