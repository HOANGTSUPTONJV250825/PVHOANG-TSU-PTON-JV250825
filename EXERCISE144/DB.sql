CREATE DATABASE Banking;

USE Banking;

CREATE TABLE TransBank(
                          ID INT PRIMARY KEY AUTO_INCREMENT,
                          Balance DECIMAL
);

INSERT INTO TransBank(ID,Balance) VALUE (1,5000000),(2,5000000);

DELIMITER //
CREATE PROCEDURE find_all()
BEGIN
    SELECT * FROM TransBank;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE transfer_funds(
    IN ID_from INT,
    IN ID_to INT,
    IN Amount DECIMAL
)
BEGIN
    DECLARE from_balance DECIMAL;
    START TRANSACTION;
    SELECT Balance INTO from_balance FROM TransBank WHERE ID = ID_from FOR UPDATE ;
    IF from_balance >= Amount AND Amount > 0 THEN
        UPDATE TransBank SET Balance = Balance - Amount WHERE ID = ID_from;
        UPDATE TransBank SET Balance = Balance + Amount WHERE ID = ID_to;
        COMMIT ;
    ELSE
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'So du khong du de chuyen tien';
    END IF;
end //
DELIMITER ;

