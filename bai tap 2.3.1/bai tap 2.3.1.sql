CREATE DATABASE QuanLyCuaHang;

USE QuanLyCuaHang;

CREATE TABLE KhachHang(
MaKH INT PRIMARY KEY,
TenKH VARCHAR(50) NOT NULL,
NgaySinh DATE,
DiaChi VARCHAR(100)
);

INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, DiaChi)
VALUE 
(1, 'Nguyễn Văn A', '1990-05-12', 'Hà Nội'),
(2, 'Trần Thị B', '1995-09-23', 'TP. Hồ Chí Minh'),
(3, 'Lê Văn C', '1988-12-01', 'Đà Nẵng');

SELECT *
FROM KhachHang;