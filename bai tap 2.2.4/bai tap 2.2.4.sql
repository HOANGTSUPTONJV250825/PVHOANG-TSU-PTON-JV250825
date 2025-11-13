CREATE DATABASE customerDB;

USE customerDB;

CREATE TABLE customer(
customerID INT PRIMARY KEY,
customerName VARCHAR(100),
customerAddress VARCHAR(100)
);
CREATE TABLE orders(
ordersID INT PRIMARY KEY,
ordersData VARCHAR(100),
customerID INT,
totalAmout INT,
CONSTRAINT fk_customer_ID
     FOREIGN KEY (customerID)
     REFERENCES customer(customerID),
CONSTRAINT chk_totalAmount_positive
        CHECK (totalAmout >= 0)
);

INSERT INTO customer (customerID, customerName, customerAddress)
VALUES
(1, 'Nguyen Van A', 'Ha Noi'),
(2, 'Tran Thi B', 'Da Nang'),
(3, 'Le Van C', 'Ho Chi Minh'),
(4, 'Pham Thi D', 'Hai Phong'),
(5, 'Do Van E', 'Can Tho');

INSERT INTO orders (ordersID, ordersData, customerID, totalAmout)
VALUES
(101, '2025-11-01', 1, 250000),
(102, '2025-11-02', 2, 450000),
(103, '2025-11-03', 3, 120000),
(104, '2025-11-04', 1, 800000),
(105, '2025-11-05', 5, 320000);

DROP TABLE orders;
