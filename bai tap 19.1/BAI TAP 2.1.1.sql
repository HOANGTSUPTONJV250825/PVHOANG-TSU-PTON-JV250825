IF DB_ID('BookStore') IS NOT NULL
    DROP DATABASE BookStore;
GO
CREATE DATABASE BookStore;
GO
USE BookStore;
GO
CREATE TABLE Books (
    BookID INT IDENTITY(1,1) PRIMARY KEY,
    Title NVARCHAR(255),
    Author NVARCHAR(255),
    Price DECIMAL(10,2),
    PublicationDate DATE
);
GO
INSERT INTO Books (Title, Author, Price, PublicationDate)
VALUES
(N'Lập trình T-SQL cơ bản', N'Nguyễn Văn A', 75.50, '2022-05-10'),
(N'Cơ sở dữ liệu nâng cao', N'Lê Thị B', 120.00, '2021-11-25'),
(N'SQL cho người mới bắt đầu', N'Trần Văn C', 45.00, '2020-07-14');
GO
SELECT * FROM Books;
GO
SELECT Title, Author FROM Books WHERE Price > 50;
GO
