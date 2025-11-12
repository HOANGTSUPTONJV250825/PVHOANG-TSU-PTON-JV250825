CREATE DATABASE companyDB;

USE companyDB;

CREATE TABLE Employees(
EmployeesID INT PRIMARY KEY,
FirstName VARCHAR(100),
LastName VARCHAR(100),
HireDate DATE,
Salary INT
);

ALTER TABLE Employees
ADD Department VARCHAR(100);

ALTER TABLE Employees
MODIFY Salary DECIMAL(10,2);