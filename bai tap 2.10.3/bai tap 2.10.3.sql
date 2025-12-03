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

ALTER TABLE InventoryChanges
MODIFY changeID INT NOT NULL AUTO_INCREMENT NOT NULL;

ALTER TABLE InventoryChanges
DROP FOREIGN KEY fk_InventoryChanges_Products;

ALTER TABLE InventoryChanges
ADD CONSTRAINT fk_InventoryChanges_Products
FOREIGN KEY (productID) REFERENCES Products(productID)
ON DELETE CASCADE;

-- Thay đổi cấu trúc bảng Products để bao gồm một trường LastUpdated

ALTER TABLE Products
ADD LastUpdated DATETIME; 

-- Tạo Trigger AfterProductUpdateSetDate để cập nhật trường LastUpdated khi có thay đổi

DROP TRIGGER IF EXISTS AfterProductUpdateSetDate;

DELIMITER $$
CREATE TRIGGER  AfterProductUpdateSetDate
BEFORE UPDATE ON Products
FOR EACH ROW
BEGIN
    SET NEW.LastUpdated = CURRENT_TIMESTAMP();
END $$
DELIMITER ;

UPDATE Products
SET quantity = 6
WHERE productID = 2;
