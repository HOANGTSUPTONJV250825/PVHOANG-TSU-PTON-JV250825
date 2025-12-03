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

-- Tạo Trigger BeforeProductDelete để kiểm tra số lượng sản phẩm trước khi xóa:
-- Kiểm tra xóa một sản phẩm có số lượng lớn hơn 10 và kiểm tra thông báo lỗi.

DROP TRIGGER IF EXISTS BeforeProductDelete;

DELIMITER $$
CREATE TRIGGER BeforeProductDelete 
BEFORE DELETE ON Products
FOR EACH ROW
BEGIN
     IF OLD.quantity > 10 THEN SIGNAL SQLSTATE '45000' SET message_text = 'khong the xoa khi so luong san pham lon hon 10 ';
     END IF;
END $$
DELIMITER ;

UPDATE Products
SET quantity = 15
WHERE productID =3;

DELETE FROM Products WHERE productID = 1;
