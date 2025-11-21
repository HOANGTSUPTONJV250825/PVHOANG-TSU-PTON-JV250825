USE companyDB;

CREATE TABLE Category(
CategoryID INT PRIMARY KEY,
CategoryName VARCHAR(100)
);

CREATE TABLE products(
ProductID INT PRIMARY KEY,
ProductName VARCHAR(100),
Price DECIMAL(10,2),
CategoryID INT,
CONSTRAINT fk_product_category
         FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

INSERT INTO Category(CategoryID, CategoryName)
VALUES
(1, 'thuc an chan nuoi'),
(2, 'phan bon'),
(3, 'thuoc bao ve thuc vat');

INSERT INTO products(ProductID, ProductName, Price, CategoryID)
VALUES
(4, 'cam heo', 100000, 1),
(5, 'phan kali', 30000, 2),
(6, 'thuoc tru sau', 40000, 3);

CREATE TABLE customers(
CustomerID INT PRIMARY KEY,
CustomerName VARCHAR(100),
CustomerEmail VARCHAR(255)
);

CREATE TABLE orders(
OrderID INT PRIMARY KEY,
CustomerID INT,
OderDate DATE,
CONSTRAINT fk_orders_customers
    FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID)
);

CREATE TABLE order_details(
OrderID INT,
ProductID INT,
Quantity INT,
Price DECIMAL(10,2),
CONSTRAINT fk_order_orderDetail
     FOREIGN KEY (OrderID) REFERENCES orders(OrderID),
CONSTRAINT fk_products_orderDetail
     FOREIGN KEY (ProductID) REFERENCES products(ProductID)
);

INSERT INTO customers(CustomerID, CustomerName, CustomerEmail)
VALUES
(1, 'Tran Van T', 'tvt@gmail.com'),
(2, 'Tran Van H', 'tvH@gmail.com');

INSERT INTO customers(CustomerID, CustomerName, CustomerEmail)
VALUES
(3, 'Tran Van O', 'tvO@gmail.com'),
(4, 'Tran Van K', 'tvK@gmail.com');

INSERT INTO orders(OrderID, CustomerID, OderDate)
VALUES
(1, 2, '2025-11-01'),
(2, 1, '2025-11-02'),
(3, 2, '2025-11-03'),
(4, 1, '2025-11-04'),
(5, 2, '2025-11-05');

DELIMITER $$

CREATE TRIGGER trg_calc_price
BEFORE INSERT ON order_details
FOR EACH ROW
BEGIN
    SET NEW.Price = (
        SELECT Price 
        FROM products 
        WHERE ProductID = NEW.ProductID
    ) * NEW.Quantity;
END$$

DELIMITER ;

INSERT INTO order_details(OrderID, ProductID, Quantity)
VALUES
(1, 2, 3),
(3, 1, 2),
(2, 4, 5),
(5, 5, 7),
(5, 6, 9);

SELECT DISTINCT
    customers.CustomerName AS tenKhachHang,
    customers.CustomerID AS daDatHang
FROM customers
JOIN orders
   ON customers.CustomerID = orders.CustomerID;
   
SELECT c.CustomerID, c.CustomerName
FROM customers c
LEFT JOIN orders o
    ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;
   
SELECT 
    c.CustomerID,
    c.CustomerName,
    SUM(od.Quantity * od.Price) AS TongDoanhThu
FROM customers c
JOIN orders o
    ON c.CustomerID = o.CustomerID
JOIN order_details od
    ON o.OrderID = od.OrderID
GROUP BY c.CustomerID, c.CustomerName;

SELECT 
    c.CustomerID,
    c.CustomerName,
    p.ProductName,
    p.Price AS GiaCaoNhat
FROM products p
JOIN order_details od 
   ON od.ProductID = p.ProductID
JOIN orders o 
   ON o.OrderID = od.OrderID
JOIN customers c 
   ON c.CustomerID = o.CustomerID
WHERE p.Price = (SELECT MAX(Price) FROM products);

SELECT*
FROM products
WHERE Price BETWEEN 5000 AND 30000;

SELECT*
FROM products
WHERE ProductName LIKE '%c%';

SELECT 
    c.CategoryName AS tenDanhMucSP,
    AVG(p.Price) AS GiaTrungBinh
FROM Category c
JOIN products p
   ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryName;

SELECT 
    c.CategoryName AS tenDanhMucSP,
    AVG(p.Price) AS GiaTrungBinh
FROM Category c
JOIN products p
   ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryName;

SELECT 
    ProductID,
    ProductName,
    Price
FROM products
WHERE Price > (SELECT AVG(Price) FROM products);

SELECT 
    ProductID,
    ProductName,
    Price
FROM products
WHERE Price = (SELECT MIN(Price) FROM products);




















