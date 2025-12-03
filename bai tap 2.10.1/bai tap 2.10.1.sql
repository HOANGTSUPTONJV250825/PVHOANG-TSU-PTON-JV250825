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

INSERT INTO InventoryChanges(changeID, productID, oldQuantity, newQuantity, changeDate)
VALUES
(1, 1, 1, 5, '2025-01-05 10:30:00'),
(2, 3, 5, 6, '2025-03-05 14:30:00'),
(3, 4, 4, 5, '2025-06-05 22:00:00'),
(4, 2, 3, 2, '2025-07-05 10:30:00'),
(5, 5, 5, 2, '2025-08-05 10:30:00');

ALTER TABLE InventoryChanges
MODIFY changeID INT NOT NULL AUTO_INCREMENT NOT NULL;

-- Tạo Trigger AfterProductUpdate để ghi lại các thay đổi số lượng hàng:

DROP TRIGGER IF EXISTS AfterProductUpdate;

DELIMITER $$
CREATE TRIGGER AfterProductUpdate 
AFTER UPDATE ON Products
FOR EACH ROW
BEGIN
     INSERT INTO InventoryChanges(productID, oldQuantity, newQuantity, changeDate)
     VALUES 
     (NEW.productID, OLD.quantity, NEW.quantity, CURRENT_TIMESTAMP());
END $$
DELIMITER ;

UPDATE Products
SET quantity = 10
WHERE productID =3;
