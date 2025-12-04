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

CREATE TABLE TransactionHistory(
historyID INT PRIMARY KEY AUTO_INCREMENT,
transactionID INT NOT NULL,
accountID INT NOT NULL,
amount DECIMAL(10,2) NOT NULL,
transactionDate DATETIME NOT NULL,
type VARCHAR(50),
CONSTRAINT fk_TransactionHistory_Transactions
       FOREIGN KEY (transactionID) REFERENCES Transactions(transactionID),
CONSTRAINT fk_TransactionHistory_Accounts
       FOREIGN KEY (accountID) REFERENCES Accounts(accountID)
);


-- Viết một stored procedure để thực hiện một giao dịch chuyển tiền từ một tài khoản sang tài khoản khác. Stored procedure này cần đảm bảo rằng giao dịch là nguyên tử (atomic) và số dư của tài khoản nguồn không bị âm.

DROP PROCEDURE IF EXISTS TransferMoney;

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

DROP TRIGGER IF EXISTS transactionHistory;

-- Thêm một bản ghi vào bảng TransactionHistory mỗi khi có giao dịch từ hoặc đến một tài khoản.
-- Theo dõi tổng số tiền giao dịch trong một khoảng thời gian cụ thể cho mỗi tài khoản.

DELIMITER $$
CREATE TRIGGER transactionHistory
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
     
     INSERT INTO TransactionHistory(transactionID, accountID, amount, transactionDate, type)
     VALUES
     (NEW.transactionID,
      NEW.fromAccountID,
      NEW.amount,
      CURRENT_TIMESTAMP(),
      'GUI');
      
     INSERT INTO TransactionHistory(transactionID, accountID, amount, transactionDate, type)
     VALUES
      (NEW.transactionID,
      NEW.toAccountID,
      NEW.amount,
      CURRENT_TIMESTAMP(),
      'NHAN');
      
END $$
DELIMITER ;

CALL TransferMoney(9999, 8888, 500000);


