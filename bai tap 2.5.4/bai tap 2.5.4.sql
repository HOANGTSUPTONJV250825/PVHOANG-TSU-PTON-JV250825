USE companyDB;

CREATE TABLE productss(
productID INT PRIMARY KEY,
productName VARCHAR(100) NOT NULL,
price DECIMAL(10,2) NOT NULL
);

INSERT INTO productss(productID, productName, price)
VALUES
(1, 'Laptop Dell Inspiron', 24000000),
(2, 'Chuột Logitech M331', 750000),
(3, 'Bàn phím cơ Keychron K2', 2100000),
(4, 'Màn hình Samsung 24 inch', 9600000),
(5, 'Ổ cứng SSD Samsung 1TB', 6500000),
(6, 'Tai nghe Sony WH-1000XM4', 4400000),
(7, 'Camera An ninh Xiaomi', 1600000),
(8, 'Router WiFi TP-Link', 2100000),
(9, 'USB Kingston 64GB', 500000),
(10, 'Pin dự phòng Anker 20000mAh', 1800000);

SELECT 
    productName,
    price
FROM productss
WHERE price = ( SELECT MAX(price) FROM productss);

SELECT 
    productName,
    price
FROM productss
WHERE price = ( SELECT MIN(price) FROM productss);