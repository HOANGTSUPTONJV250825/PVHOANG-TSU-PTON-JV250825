CREATE DATABASE QLMH;

USE QLMH;

CREATE TABLE Customer(
customer_ID VARCHAR(5) PRIMARY KEY NOT NULL,
customer_full_name VARCHAR(100) NOT NULL,
customer_email VARCHAR(100) NOT NULL UNIQUE,
customer_phone VARCHAR(15) NOT NULL,
customer_address VARCHAR(255) NOT NULL
);

CREATE TABLE Room(
room_ID VARCHAR(5) PRIMARY KEY NOT NULL,
room_type VARCHAR(50) NOT NULL,
room_price DECIMAL(10,2) NOT NULL,
room_status VARCHAR(20) NOT NULL,
room_area INT NOT NULL
);

CREATE TABLE Booking(
booking_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
customer_ID VARCHAR(5) NOT NULL,
room_ID VARCHAR(5) NOT NULL,
check_in_date DATE NOT NULL,
check_out_date DATE NOT NULL,
total_amount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_Booking_Customer
     FOREIGN KEY (customer_ID) REFERENCES Customer(customer_ID),
CONSTRAINT fk_Booking_Room
     FOREIGN KEY (room_ID) REFERENCES Room(room_ID)     
);

CREATE TABLE Payment(
payment_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
booking_ID INT NOT NULL,
payment_method VARCHAR(50) NOT NULL,
payment_date DATE NOT NULL,
payment_amount DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_Payment_Booking
     FOREIGN KEY (booking_ID) REFERENCES Booking(booking_ID)  
);

INSERT INTO Customer(customer_ID, customer_full_name, customer_email, customer_phone, customer_address)
VALUES
('C001', 'Nguyen Anh Tu', 'tu.nguyen@example.com', '0912345678', 'Hanoi, Vietnam'),
('C002', 'Tran Thi Mai', 'mai.tran@example.com', '0923456789', 'Ho Chi Minh, Vietnam'),
('C003', 'Le Minh Hoang', 'hoang.le@example.com', '0934567890', 'Danang, Vietnam'),
('C004', 'Pham Hoang Nam', 'nam.pham@example.com', '0945678901', 'Hue, Vietnam'),
('C005', 'Vu Minh Thu', 'thu.vu@example.com', '0956789012', 'Hai Phong, Vietnam');

INSERT INTO Room(room_ID, room_type, room_price, room_status, room_area)
VALUES
('R001', 'Single', 100.0, 'Available', 25),
('R002', 'Double', 150.0, 'Booked', 40),
('R003', 'Suite', 250.0, 'Available', 60),
('R004', 'Single', 120.0, 'Booked', 30),
('R005', 'Double', 160.0, 'Available', 35);

INSERT INTO Booking(customer_ID, room_ID, check_in_date, check_out_date, total_amount)
VALUES
('C001', 'R001', '2025-03-01', '2025-03-05', 400.0),
('C002', 'R002', '2025-03-02', '2025-03-06', 600.0),
('C003', 'R003', '2025-03-03', '2025-03-07', 1000.0),
('C004', 'R004', '2025-03-04', '2025-03-08', 480.0),
('C005', 'R005', '2025-03-05', '2025-03-09', 800.0);

INSERT INTO Payment(booking_ID, payment_method, payment_date, payment_amount)
VALUES
(1, 'Cash', '2025-03-05', 400.0),
(2, 'Credit Card', '2025-03-06', 600.0),
(3, 'Bank Transfer', '2025-03-07', 1000.0),
(4, 'Cash', '2025-03-08', 480.0),
(5, 'Credit Card', '2025-03-09', 800.0);

UPDATE Booking
SET total_amount = (SELECT room_price FROM Room WHERE room_status = 'Booked') * DATEDIFF(check_out_date, check_in_date)
WHERE check_in_date < CURRENT_TIMESTAMP;

DELETE FROM Payment 
WHERE payment_method = 'Cash' AND payment_amount < 500;

SELECT *
FROM Customer
ORDER BY customer_full_name ASC;

SELECT 
room_ID,
room_type,
room_price,
room_area
FROM Room
ORDER BY room_price DESC;

SELECT  
c.customer_ID,
c.customer_full_name,
b.room_ID,
b.check_in_date,
b.check_out_date
FROM Booking b
JOIN Customer c
ON c.customer_ID = b.customer_ID;

SELECT  
c.customer_ID AS 'MA KHACH HANG',
c.customer_full_name AS 'TEN KHACH HANG',
p.payment_method AS 'PHUONG THUC THANH TOAN',
p.payment_amount AS 'TONG SO TIEN THANH TOAN'
FROM Payment p
JOIN Booking b
ON p.booking_ID = b.booking_ID
JOIN Customer c
ON c.customer_ID = b.customer_ID
ORDER BY p.payment_amount DESC;

SELECT*
FROM Customer
WHERE customer_ID < 'C005' AND customer_ID > 'C001'
ORDER BY customer_full_name;

SELECT 
c.customer_ID AS 'MA KHACH HANG',
c.customer_full_name AS 'TEN KHACH HANG',
COUNT(b.room_ID) AS 'SO LUONG PHONG DA DAT'
FROM Booking b
JOIN Customer c
ON b.customer_ID = c.customer_ID
WHERE b.total_amount > 1000 
GROUP BY c.customer_ID
HAVING COUNT(b.room_ID) > 1;

SELECT 
    r.room_ID AS 'MA PHONG',
    r.room_type AS 'LOAI PHONG',
    r.room_price AS 'GIA PHONG',
    SUM(b.total_amount) AS 'TONG_SO_TIEN_THANH_TOAN'
FROM Room r
JOIN Booking b ON r.room_ID = b.room_ID
GROUP BY r.room_ID
HAVING SUM(b.total_amount) < 1000
   AND COUNT(DISTINCT b.customer_ID) >= 3;

SELECT
    c.customer_ID AS 'MA KHACH HANG',
    c.customer_full_name AS 'TEN KHACH HANG',
    b.room_ID AS 'MA PHONG',
    SUM(b.total_amount) AS 'TONG_SO_TIEN_THANH_TOAN'
FROM Customer c
JOIN Booking b ON c.customer_ID = b.customer_ID
GROUP BY c.customer_ID, b.room_ID
HAVING SUM(b.total_amount) > 1000;

SELECT
    customer_ID AS 'MA KH',
    customer_full_name AS 'HO TEN',
    customer_email AS 'EMAIL',
    customer_phone AS 'SDT'
FROM Customer
WHERE customer_full_name LIKE '%Minh%'
   OR customer_address LIKE '%Hanoi%'
ORDER BY customer_full_name ASC;

SELECT
    room_ID AS 'MA PHONG',
    room_type AS 'LOAI PHONG',
    room_price AS 'GIA PHONG'
FROM Room
ORDER BY room_price DESC
LIMIT 5 OFFSET 5;

CREATE VIEW THONGTINPHONG
AS
SELECT
    r.room_ID AS 'MA_PHONG',
    r.room_type AS 'LOAI_PHONG',
    c.customer_ID AS 'MA_KHACH_HANG',
    c.customer_full_name AS 'TEN_KHACH_HANG'
FROM Booking b
JOIN Room r ON b.room_ID = r.room_ID
JOIN Customer c ON b.customer_ID = c.customer_ID
WHERE b.check_in_date < '2025-03-10';

SELECT* FROM THONGTINPHONG;

CREATE VIEW THONGTINKHACHHANG AS
SELECT
    c.customer_ID AS 'MA_KHACH_HANG',
    c.customer_full_name AS 'TEN_KHACH_HANG',
    r.room_ID AS 'MA_PHONG',
    r.room_area AS 'DIEN_TICH_PHONG'
FROM Booking b
JOIN Customer c ON b.customer_ID = c.customer_ID
JOIN Room r ON b.room_ID = r.room_ID
WHERE r.room_area > 30;

SELECT* FROM THONGTINKHACHHANG;