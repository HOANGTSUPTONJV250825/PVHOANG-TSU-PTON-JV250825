CREATE DATABASE StudentDB;

USE StudentDB;

CREATE TABLE Students(
                         student_id INT PRIMARY KEY AUTO_INCREMENT,
                         full_name VARCHAR(100) NOT NULL ,
                         date_of_birth DATE NOT NULL ,
                         email VARCHAR(100) NOT NULL UNIQUE
);

DELIMITER //
CREATE PROCEDURE get_all_students()
BEGIN
SELECT * FROM Students;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_student(
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
INSERT INTO Students(full_name,date_of_birth,email)
    VALUE (in_full_name,in_date_of_birth,in_email);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_student(
    IN new_student_id INT,
    IN new_full_name VARCHAR(100),
    IN new_date_of_birth DATE,
    IN new_email VARCHAR(100)
)
BEGIN
UPDATE Students SET full_name = new_full_name,
                    date_of_birth = new_date_of_birth,
                    email = new_email
WHERE student_id = new_student_id;
end //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_student_by_id(IN find_ID INT)
BEGIN
SELECT * FROM Students WHERE student_id = find_ID;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_student(IN in_id INT)
BEGIN
DELETE FROM Students WHERE student_id = in_id;
end //

DELIMITER ;