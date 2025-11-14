CREATE DATABASE NhaSach;

USE NhaSach;

CREATE TABLE Sach(
MaSach INT PRIMARY KEY,
TenSach VARCHAR(100),
NamXuatBan YEAR
);

CREATE TABLE TacGia(
MaTacGia INT PRIMARY KEY,
TenTacGia VARCHAR(50)
);

CREATE TABLE Sach_TacGia(
MaSach INT,
MaTacGia INT,

   CONSTRAINT fk_Sach
        FOREIGN KEY (MaSach)
        REFERENCES Sach(MaSach)
        ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_TacGia
        FOREIGN KEY (MaTacGia)
        REFERENCES TacGia(MaTacGia)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Sach (MaSach, TenSach, NamXuatBan)
VALUES
(1, 'Lập Trình C Cơ Bản', 2018),
(2, 'Học SQL Nhanh', 2020),
(3, 'Phân Tích Hệ Thống', 2019);

INSERT INTO TacGia (MaTacGia, TenTacGia)
VALUES
(1, 'Nguyễn Văn A'),
(2, 'Trần Thị B'),
(3, 'Lê Văn C');

INSERT INTO Sach_TacGia (MaSach, MaTacGia)
VALUES
(1, 1),  
(2, 2), 
(3, 3);  

SELECT *
FROM Sach;

SELECT *
FROM TacGia;

SELECT *
FROM Sach_TacGia;

DROP TABLE Sach_TacGia;

DROP TABLE Sach;
