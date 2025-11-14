CREATE DATABASE TMDT;

USE TMDT;

CREATE TABLE DanhMuc (
    MaDM INT PRIMARY KEY,
    TenDM VARCHAR(100) NOT NULL
);

CREATE TABLE SanPham (
    MaSP INT PRIMARY KEY,
    TenSP VARCHAR(100) NOT NULL,
    Gia DECIMAL(10,2) NOT NULL,
    MaDM INT NOT NULL,
    CONSTRAINT fk_danhmuc
        FOREIGN KEY (MaDM) REFERENCES DanhMuc(MaDM)
);


CREATE TABLE KhachHang (
    MaKH INT PRIMARY KEY,
    TenKH VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL
);

CREATE TABLE DonHang (
    MaDH INT PRIMARY KEY,
    MaKH INT NOT NULL,
    NgayDat DATE NOT NULL,
    CONSTRAINT fk_donhang_khachhang
        FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
);

CREATE TABLE ChiTietDonHang (
    MaDH INT NOT NULL,
    MaSP INT NOT NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaDH, MaSP),

    CONSTRAINT fk_ctdh_donhang
        FOREIGN KEY (MaDH) REFERENCES DonHang(MaDH),

    CONSTRAINT fk_ctdh_sanpham
        FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);


INSERT INTO DanhMuc (MaDM, TenDM)
VALUES
(1, 'Điện thoại'),
(2, 'Laptop'),
(3, 'Phụ kiện');

INSERT INTO SanPham (MaSP, TenSP, Gia, MaDM)
VALUES
(1, 'iPhone 14', 20000000, 1),
(2, 'Samsung Galaxy S23', 18000000, 1),
(3, 'Dell XPS 13', 35000000, 2);

INSERT INTO KhachHang (MaKH, TenKH, Email)
VALUES
(1, 'Nguyễn Văn A', 'vana@example.com'),
(2, 'Trần Thị B', 'thib@example.com');

INSERT INTO DonHang (MaDH, MaKH, NgayDat)
VALUES
(1001, 1, '2024-01-10'),
(1002, 2, '2024-01-12');

INSERT INTO ChiTietDonHang (MaDH, MaSP, SoLuong)
VALUES
(1001, 1, 2),   
(1002, 2, 1);   


SELECT *
FROM SanPham
WHERE MaDM = 1;
