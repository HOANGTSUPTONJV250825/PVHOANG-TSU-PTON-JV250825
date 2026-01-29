CREATE DATABASE Students;

USE Students;

CREATE TABLE Students(
                         ID INT PRIMARY KEY AUTO_INCREMENT,
                         Name VARCHAR(50) NOT NULL ,
                         Age INT NOT NULL
);

DELIMITER //
CREATE PROCEDURE add_students(
    IN addName VARCHAR(50),
    IN addAge INT
)
BEGIN
INSERT INTO Students(Name, Age)
    VALUE (addName,addAge);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE FindAll()
BEGIN
SELECT * FROM Students;
end //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE find_student_by_ID(IN studentID INT)
BEGIN
SELECT * FROM Students WHERE ID = studentID;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_student(
    IN updateID INT,
    IN updateName VARCHAR(50),
    IN updateAge INT
)
BEGIN
UPDATE Students SET Name = updateName,
                    Age = updateAge
WHERE ID = updateID;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_students_by_age(IN inAge INT)
BEGIN
DELETE FROM Students WHERE Age < inAge;
end //
DELIMITER ;



