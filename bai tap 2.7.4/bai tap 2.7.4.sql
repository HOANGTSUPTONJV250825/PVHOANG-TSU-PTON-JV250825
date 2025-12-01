CREATE DATABASE SalesDB;

USE SalesDB;

CREATE TABLE Orders(
orderID INT PRIMARY KEY,
customerID INT ,
totalAmount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_order_customers
       FOREIGN KEY (customerID)REFERENCES Customers(customerID)
);

CREATE TABLE Customers(
customerID INT PRIMARY KEY,
customerName VARCHAR(100) NOT NULL,
phone VARCHAR(15),
createdAt DATETIME
);

CREATE TABLE OrderDetails(
orderDetailID INT PRIMARY KEY,
orderID INT,
productID INT,
quantity INT NOT NULL,
unitPrice DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_orders_orderDetails
     FOREIGN KEY (orderID) REFERENCES Orders(orderID),
CONSTRAINT fk_products_orderDetails
     FOREIGN KEY (productID) REFERENCES Products(productID)
);

CREATE TABLE Products(
productID INT PRIMARY KEY,
productName VARCHAR(255) NOT NULL,
category VARCHAR(255),
price DECIMAL(10,2) NOT NULL
);

ALTER TABLE Customers
ADD COLUMN email VARCHAR(255);

ALTER TABLE Orders
ADD COLUMN orderDate DATETIME;


CREATE INDEX idx_customer_email
ON Customers(email);

CREATE INDEX idx_order_orderDate
ON Orders(orderDate);

SHOW INDEX FROM Customers;

SHOW INDEX FROM Orders;

CREATE VIEW CustomerOrders 
AS 
SELECT orderID, customerName AS `ho va ten khach hang`, orderDate, totalAmount
FROM Customers c
JOIN Orders o
ON c.customerID = o.customerID;

SELECT * FROM CustomerOrders;

CREATE TABLE OrderItems(
orderItemID INT PRIMARY KEY,
orderID INT NOT NULL,
productID INT NOT NULL,
quantity INT,
price DECIMAL(10,2),
CONSTRAINT fk_orders_orderItems
    FOREIGN KEY (orderID) REFERENCES Orders(orderID),
CONSTRAINT fk_products_orderItems
    FOREIGN KEY (productID) REFERENCES Products(productID)
);

INSERT INTO Customers (customerID, customerName, phone, createdAt, email) VALUES
(1, 'Nguyen Van A', '0901111111', '2025-01-01 10:00:00', 'a@example.com'),
(2, 'Tran Thi B', '0902222222', '2025-01-05 12:00:00', 'b@example.com'),
(3, 'Le Van C', '0903333333', '2025-02-01 09:30:00', 'c@example.com'),
(4, 'Pham Thi D', '0904444444', '2025-02-10 15:20:00', 'd@example.com'),
(5, 'Hoang Van E', '0905555555', '2025-03-01 08:45:00', 'e@example.com');

INSERT INTO Products (productID, productName, category, price) VALUES
(1, 'Laptop Dell XPS', 'Electronics', 1500.00),
(2, 'Chuột Logitech', 'Accessories', 25.00),
(3, 'Bàn phím Cơ', 'Accessories', 80.00),
(4, 'Tai nghe Sony', 'Audio', 120.00),
(5, 'Màn hình LG 27"', 'Electronics', 300.00);

INSERT INTO Orders (orderID, customerID, totalAmount, orderDate) VALUES
(1, 1, 250.00, '2025-03-10 09:00:00'),
(2, 2, 1550.00, '2025-03-11 10:30:00'),
(3, 3, 200.00,  '2025-03-12 11:45:00'),
(4, 4, 450.00,  '2025-03-13 14:20:00'),
(5, 5, 80.00,   '2025-03-14 16:00:00');

INSERT INTO OrderDetails (orderDetailID, orderID, productID, quantity, unitPrice) VALUES
(1, 1, 2, 2, 25.00),    -- Chuột
(2, 1, 3, 1, 80.00),    -- Bàn phím
(3, 2, 1, 1, 1500.00),  -- Laptop
(4, 4, 4, 2, 120.00),   -- Tai nghe
(5, 5, 3, 1, 80.00);    -- Bàn phím

INSERT INTO OrderItems (orderItemID, orderID, productID, quantity, price) VALUES
(1, 1, 2, 2, 25.00),
(2, 1, 3, 1, 80.00),
(3, 2, 1, 1, 1500.00),
(4, 4, 4, 2, 120.00),
(5, 5, 3, 1, 80.00);

UPDATE Orders
SET totalAmount = 500
WHERE orderID = 1;

CREATE INDEX idx_orderItems_oderdetail
ON OrderItems(orderID);

SHOW INDEX FROM OrderItems;

UPDATE CustomerOrders
SET totalAmount = 250 
WHERE orderID = 1;

SELECT * FROM CustomerOrders;