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

UPDATE products
SET Price = 50000
WHERE ProductID = 3;

DELETE FROM products
WHERE ProductID = 3;

SELECT
    ProductName AS tenSanPham,
    Price AS gia
FROM products
ORDER BY price ASC;

SELECT
    Category.CategoryName AS tenDanhMuc,
    COUNT(products.ProductID) AS soLuongSanPham
FROM Category
JOIN products
ON Category.CategoryID = products.CategoryID
GROUP BY Category.CategoryName;


