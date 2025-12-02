CREATE DATABASE SalesDB;

USE SalesDB;

CREATE TABLE Sales(
saleID INT PRIMARY KEY,
orderID INT,
saleDate DATE,
saleAmount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_Sales_Orders
     FOREIGN KEY (orderID) REFERENCES Orders(orderID)
);

CREATE TABLE Orders(
orderID INT PRIMARY KEY,
customerID INT ,
orderDate DATETIME,
totalAmount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_order_customers
       FOREIGN KEY (customerID)REFERENCES Customers(customerID)
);

CREATE TABLE Customers(
customerID INT PRIMARY KEY,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL
);

CREATE TABLE Products(
productID INT PRIMARY KEY,
productName VARCHAR(255) NOT NULL,
price DECIMAL(10,2) NOT NULL,
promotionID INT,
CONSTRAINT fk_Products_Promotions
    FOREIGN KEY (promotionID) REFERENCES Promotions(promotionID)
);

CREATE TABLE Promotions(
promotionID INT PRIMARY KEY,
promotionName VARCHAR(100) NOT NULL,
discountPercentage DECIMAL(5,2) NOT NULL
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

CREATE INDEX idx_customer_email
ON Customers(email);

CREATE INDEX idx_order_orderDate
ON Orders(orderDate);

CREATE INDEX idx_sales_saledate
ON Sales(saleDate);

CREATE INDEX idx_Promotions_promotionName
ON Promotions(promotionName);

SHOW INDEX FROM Customers;

SHOW INDEX FROM Orders;

SHOW INDEX FROM Promotions;

SHOW INDEX FROM Sales;

INSERT INTO Customers(customerID, firstName, lastName, email)
VALUES
(1, 'John', 'Smith', 'john.smith@example.com'),
(2, 'Emma', 'Johnson', 'emma.johnson@example.com'),
(3, 'Michael', 'Brown', 'michael.brown@example.com'),
(4, 'Sarah', 'Davis', 'sarah.davis@example.com'),
(5, 'David', 'Wilson', 'david.wilson@example.com');

INSERT INTO Promotions(promotionID, promotionName, discountPercentage)
VALUES
(1, 'New Year Sale', 10.00),
(2, 'Holiday Promo', 15.00),
(3, 'Black Friday', 20.00),
(4, 'Clearance', 5.00),
(5, 'No Promotion', 0.00);

INSERT INTO Products(productID, productName, price, promotionID)
VALUES
(1, 'Laptop A', 1200.00, 1),
(2, 'Laptop B', 1500.00, 2),
(3, 'Tablet X', 600.00, 3),
(4, 'Headphone Y', 120.00, 4),
(5, 'Mouse Z', 25.00, 5);

INSERT INTO Orders(orderID, customerID, orderDate, totalAmount)
VALUES
(1, 1, '2025-01-05 10:30:00', 1500.00),
(2, 1, '2025-03-12 15:10:00', 600.00),
(3, 2, '2025-04-20 12:45:00', 1200.00),
(4, 3, '2025-05-11 09:20:00', 300.00),
(5, 4, '2025-06-18 18:00:00', 2000.00);

INSERT INTO OrderDetails(orderDetailID, orderID, productID, quantity, unitPrice)
VALUES
(1, 1, 1, 1, 1200.00),
(2, 1, 4, 1, 120.00),
(3, 2, 3, 1, 600.00),
(4, 3, 2, 1, 1500.00),
(5, 4, 5, 2, 25.00);

INSERT INTO Sales(saleID, orderID, saleDate, saleAmount)
VALUES
(1, 1, '2025-01-06', 1500.00),
(2, 2, '2025-03-13', 600.00),
(3, 3, '2025-04-21', 1200.00),
(4, 4, '2025-05-12', 300.00),
(5, 5, '2025-06-19', 2000.00);

-- Procedure sẽ cập nhật tổng số tiền của đơn hàng trong bảng Orders.

DELIMITER $$
CREATE PROCEDURE UpdateOrderTotalAmount(IN inOrderID INT, IN inNewTotalAmount DECIMAL(10,2))
BEGIN
   UPDATE Orders
   SET totalAmount = totalAmount + inNewTotalAmount
   WHERE orderID = inOrderID;
END $$
DELIMITER ;

CALL UpdateOrderTotalAmount(2,50000);
