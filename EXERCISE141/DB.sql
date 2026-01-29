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

