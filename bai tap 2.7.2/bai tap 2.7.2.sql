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