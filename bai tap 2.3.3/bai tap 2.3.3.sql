CREATE DATABASE QuanLyCuaHang;

USE QuanLyCuaHang;

CREATE TABLE SanPham (
    MaSP INT PRIMARY KEY,
    TenSP VARCHAR(100) NOT NULL,
    Gia DECIMAL(10,2),
    SoLuongTon INT DEFAULT 0
);

ALTER TABLE SanPham
ADD MoTa TEXT;

INSERT INTO SanPham (MaSP, TenSP, Gia, SoLuongTon, MoTa)
VALUES
(1, 'Bút bi Thiên Long', 5000, 100, 'Bút bi xanh thông dụng'),
(2, 'Sổ tay A5', 35000, 50, 'Sổ tay bìa cứng kích thước A5'),
(3, 'Máy tính Casio FX-580VN', 750000, 20, 'Máy tính khoa học dành cho học sinh sinh viên');

SELECT *
FROM SanPham
WHERE Gia > 50000;