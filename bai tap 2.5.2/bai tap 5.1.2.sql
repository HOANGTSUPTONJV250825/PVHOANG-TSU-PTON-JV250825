USE companyDB;

CREATE TABLE products(
productID INT PRIMARY KEY,
productName VARCHAR(100) NOT NULL,
productDueDate DATE NOT NULL
);

CREATE TABLE sales(
saleID INT PRIMARY KEY,
productID INT NOT NULL,
saleDate DATE NOT NULL,
quantity INT NOT NULL,
amount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_sales_products
        FOREIGN KEY (productID) REFERENCES products(productID)
);

INSERT INTO products (productID, productName, productDueDate)
VALUES
(1, 'Laptop Dell Inspiron', '2025-03-01'),
(2, 'Chuột Logitech M331', '2025-02-15'),
(3, 'Bàn phím cơ Keychron K2', '2025-04-10'),
(4, 'Màn hình Samsung 24 inch', '2025-03-20'),
(5, 'Tai nghe Sony WH-1000XM4', '2025-04-05'),
(6, 'Ổ cứng SSD Samsung 1TB', '2025-05-01'),
(7, 'Camera An ninh Xiaomi', '2025-02-28'),
(8, 'Router WiFi TP-Link', '2025-03-15'),
(9, 'USB Kingston 64GB', '2025-01-30'),
(10, 'Pin dự phòng Anker 20000mAh', '2025-06-10');

INSERT INTO sales (saleID, productID, saleDate, quantity, amount)
VALUES
(101, 1, '2025-01-05', 2, 24000000),
(102, 2, '2025-01-07', 5, 750000),
(103, 3, '2025-01-10', 1, 2100000),
(104, 4, '2025-01-12', 3, 9600000),
(105, 5, '2025-01-15', 1, 6500000),
(106, 6, '2025-01-18', 4, 4400000),
(107, 7, '2025-01-20', 2, 1600000),
(108, 8, '2025-01-22', 3, 2100000),
(109, 9, '2025-01-25', 10, 500000),
(110, 10, '2025-01-28', 2, 1800000);

SELECT 
      productID,
      COUNT(saleID) AS soLuongDonHang
FROM sales 
GROUP BY productID;
