CREATE DATABASE ProductDB;

USE ProductDB;

CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    Price DECIMAL(10,2),
    StockQuantity INT
);

INSERT INTO Products (ProductName, Category, Price, StockQuantity)
VALUES
('Laptop Dell Inspiron', 'Electronics', 850.00, 15),
('Office Chair', 'Furniture', 120.50, 40),
('Wireless Mouse', 'Accessories', 25.99, 100);