CREATE DATABASE InventoryManagement;

USE InventoryManagement;

CREATE TABLE Products(
productID INT PRIMARY KEY,
productName VARCHAR(100),
quantity INT
);

CREATE TABLE InventoryChanges(
changeID INT PRIMARY KEY,
productID INT NOT NULL,
oldQuantity INT,
newQuantity INT,
changeDate DATETIME,
CONSTRAINT fk_InventoryChanges_Products
    FOREIGN KEY (productID) REFERENCES Products(productID)
);

INSERT INTO Products(productID, productName, quantity)
VALUES
(1, 'Laptop A', 1),
(2, 'Laptop B', 3),
(3, 'Tablet X', 5),
(4, 'Headphone Y', 4),
(5, 'Mouse Z', 5);

-- Tạo bảng ProductSummary: SummaryID(INT, Primary Key), TotalQuantity(INT)

CREATE TABLE ProductSummary( 
SummaryID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
TotalQuantity INT 
);

-- Thêm một bản ghi khởi tạo vào bảng ProductSummary

INSERT INTO ProductSummary(SummaryID, TotalQuantity)
VALUES
(1,  0);

-- Tạo Trigger AfterProductUpdateSummary để cập nhật tổng số lượng hàng trong ProductSummary mỗi khi có thay đổi số lượng hàng trong Products:
DROP TRIGGER IF EXISTS AfterProductUpdateSummary;

DELIMITER $$
CREATE TRIGGER AfterProductUpdateSummary
AFTER UPDATE ON Products
FOR EACH ROW
BEGIN 
     INSERT INTO ProductSummary(TotalQuantity)
     VALUES ((SELECT SUM(quantity) FROM Products));
END $$
DELIMITER ;

UPDATE Products
SET quantity = 8
WHERE productID = 2;
