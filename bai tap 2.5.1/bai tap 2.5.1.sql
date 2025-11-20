CREATE TABLE Customers(
customerID INT PRIMARY KEY,
customerName VARCHAR(100),
customerEmail VARCHAR(100)
);

CREATE TABLE Orders(
orderID INT PRIMARY KEY,
customerID INT NOT NULL,
orderDate DATE NOT NULL,
tatalAmount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_customers_oders
        FOREIGN KEY (customerID) REFERENCES Customers(customerID )
);

INSERT INTO Customers (customerID, customerName, customerEmail)
VALUES
(1, 'Nguyễn Văn A', 'vana@example.com'),
(2, 'Trần Thị B', 'thib@example.com'),
(3, 'Lê Văn C', 'levanc@example.com'),
(4, 'Phạm Thị D', 'thid@example.com'),
(5, 'Hoàng Văn E', 'van.e@example.com'),
(6, 'Vũ Thị F', 'thif@example.com'),
(7, 'Đỗ Minh G', 'ming@example.com'),
(8, 'Bùi Thị H', 'thih@example.com'),
(9, 'Ngô Văn I', 'vani@example.com'),
(10, 'Lý Thị K', 'thik@example.com');

INSERT INTO Orders (orderID, customerID, orderDate, tatalAmount)
VALUES
(101, 1, '2024-01-02', 250000),
(102, 2, '2024-01-05', 350000),
(103, 3, '2024-01-10', 150000),
(104, 4, '2024-01-12', 780000),
(105, 5, '2024-01-15', 920000),
(106, 6, '2024-01-18', 120000),
(107, 7, '2024-01-20', 640000),
(108, 8, '2024-01-22', 890000),
(109, 9, '2024-01-25', 210000),
(110, 10, '2024-01-28', 450000);

SELECT 
      Orders.orderID,
      Orders.orderDate,
      Orders.tatalAmount,
      Customers.customerName,
      Customers.customerEmail
FROM Orders
JOIN Customers
ON Orders.customerID = Customers.customerID;

