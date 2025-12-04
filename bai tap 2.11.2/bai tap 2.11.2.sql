-- Bạn có hai bảng trong cơ sở dữ liệu: Accounts và Transactions. Bảng Accounts lưu thông tin về số dư tài khoản, trong khi bảng Transactions ghi lại các giao dịch.
CREATE DATABASE Accounts_transactionsDB;

USE Accounts_transactionsDB;
-- Tạo bảng Accounts

CREATE TABLE Accounts(
accountID INT PRIMARY KEY,
balance DECIMAL(10,2)
);

INSERT INTO Accounts(accountID, balance)
VALUES
(8888, 10000000),
(9999, 50000000); 

-- Tạo bảng Transactions


CREATE TABLE Transactions (
    transactionID INT PRIMARY KEY AUTO_INCREMENT,
    fromAccountID INT NOT NULL,
    toAccountID INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    transactionDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_from_acc FOREIGN KEY (fromAccountID) REFERENCES Accounts(accountID),
    CONSTRAINT fk_to_acc FOREIGN KEY (toAccountID) REFERENCES Accounts(accountID)
);

-- Viết một stored procedure để thực hiện một giao dịch chuyển tiền từ một tài khoản sang tài khoản khác. Stored procedure này cần đảm bảo rằng giao dịch là nguyên tử (atomic) và số dư của tài khoản nguồn không bị âm.

DELIMITER $$

CREATE PROCEDURE TransferMoney(
    IN p_fromAccount INT,
    IN p_toAccount INT,
    IN p_amount DECIMAL(10,2)
)
BEGIN
    DECLARE currentBalance DECIMAL(10,2);
    START TRANSACTION;
    SELECT balance INTO currentBalance
    FROM Accounts
    WHERE accountID = p_fromAccount
    FOR UPDATE;  
    IF currentBalance < p_amount THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Khong du so du de thuc hien giao dich.';
    END IF;

    UPDATE Accounts
    SET balance = balance - p_amount
    WHERE accountID = p_fromAccount;

    UPDATE Accounts
    SET balance = balance + p_amount
    WHERE accountID = p_toAccount;

    INSERT INTO Transactions(fromAccountID, toAccountID, amount)
    VALUES (p_fromAccount, p_toAccount, p_amount);

    COMMIT;
END $$

DELIMITER ;

CALL TransferMoney(8888, 9999, 500000);

CREATE TABLE Budgets(
budgetID INT PRIMARY KEY AUTO_INCREMENT,
accountID INT NOT NULL,
amount DECIMAL(10,2),
month VARCHAR(20),
CONSTRAINT fk_Budgets_Accounts
       FOREIGN KEY (accountID) REFERENCES Accounts(accountID)
);

ALTER TABLE Budgets
MODIFY amount DECIMAL(10,2) NOT NULL;

CREATE TABLE Expenses(
expenseID INT PRIMARY KEY AUTO_INCREMENT,
accountID INT NOT NULL,
amount DECIMAL(10,2),
expenseDate DATETIME,
description VARCHAR(255),
CONSTRAINT fk_Expenses_Accounts
       FOREIGN KEY (accountID) REFERENCES Accounts(accountID)
);

-- Trừ số tiền chi tiêu từ số dư tài khoản tương ứng trong bảng Accounts.

DROP PROCEDURE IF EXISTS UseControlls;

DELIMITER $$
CREATE PROCEDURE UseControlls(
IN inAmount DECIMAL(10,2),
IN inAccountID int)
BEGIN
     DECLARE currentBalance DECIMAL(10,2);
     START TRANSACTION;
     
     -- Đảm bảo rằng số dư tài khoản không bị âm và toàn bộ giao dịch phải thành công hoặc không có gì thay đổi nếu có lỗi.
     
     SELECT balance INTO currentBalance
     FROM Accounts
     WHERE accountID = inAccountID
     FOR UPDATE;
     IF currentBalance < inAmount 
     THEN ROLLBACK; 
	      SIGNAL SQLSTATE '45000'
		  SET MESSAGE_TEXT = 'Khong du so du de thuc hien giao dich.';
     END IF;
     
     UPDATE Accounts
     SET balance = balance - inAmount 
     WHERE accountID = inAccountID;
     
     -- Thêm bản ghi chi tiêu vào bảng Expenses.
     
     INSERT INTO Expenses(accountID, amount, expenseDate, description)
     VALUES
     (inAccountID, inAmount, CURRENT_TIMESTAMP(), 'chi tieu');
     
     -- Cập nhật ngân sách trong bảng Budgets nếu cần.
     
     INSERT INTO Budgets(accountID, amount, month)
     VALUES 
     (inAccountID, inAmount, MONTH(NOW()));
     
     COMMIT;
END $$
DELIMITER ;

CALL UseControlls( 500000, 8888);

CALL UseControlls( 1500000, 8888);