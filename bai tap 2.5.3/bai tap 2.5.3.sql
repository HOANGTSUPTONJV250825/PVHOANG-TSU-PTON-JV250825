USE companyDB;

CREATE TABLE department(
departmentID INT PRIMARY KEY,
departmentName VARCHAR(100)
);

CREATE TABLE employeeSalaries(
employeeID INT PRIMARY KEY,
departmentID INT NOT NULL,
salary DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_employeeSalaries_department
      FOREIGN KEY (departmentID) REFERENCES department(departmentID)
);

INSERT INTO department(departmentID, departmentName)
VALUES
(1, 'kinh doanh'),
(2, 'ki thuat'),
(3, 'bao duong'),
(4, 'san xuat'),
(5, 'gia cong'),
(6, 'quan ly san xuat'),
(7, 'HR'),
(8, 'quan ly ki thuat'),
(9, 'QC'),
(10, 'QA');

INSERT INTO employeeSalaries(employeeID, departmentID, salary)
VALUES
(1, 3, 12000000.00),
(2, 2, 5000000.00),
(3, 5, 5000000.00),
(4, 6, 23000000.00),
(5, 8, 15000000.00),
(6, 10, 8000000.00),
(7, 1, 5000000.00),
(8, 7, 8000000.00),
(9, 9, 8000000.00),
(10, 2, 6000000.00);

SELECT 
    departmentID,
    SUM(salary) AS tongLuong,
    AVG(salary) AS luongTrungBinh
FROM employeeSalaries
GROUP BY departmentID;