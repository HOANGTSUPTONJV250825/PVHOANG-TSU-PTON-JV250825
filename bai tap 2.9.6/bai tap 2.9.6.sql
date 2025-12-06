CREATE DATABASE Chinook;

USE Chinook;

CREATE TABLE Artists(
artistID INT PRIMARY KEY,
artistName VARCHAR(50),
age INT
);

INSERT INTO Artists(artistID, artistName, age) VALUES
(1, 'Adele', 35),
(2, 'Ed Sheeran', 32),
(3, 'Taylor Swift', 34),
(4, 'Bruno Mars', 38),
(5, 'Coldplay', 27);


CREATE TABLE Albums(
albumID INT PRIMARY KEY,
artistID INT NOT NULL,
albumName VARCHAR(255),
publicDate DATETIME,
CONSTRAINT fk_Artists_Album
     FOREIGN KEY (artistID) REFERENCES Artists(artistID)
);

INSERT INTO Albums(albumID, artistID, albumName, publicDate) VALUES
(1, 1, '21', '2011-01-01'),
(2, 2, 'Divide', '2017-03-03'),
(3, 3, '1989', '2014-10-27'),
(4, 4, 'Doo-Wops & Hooligans', '2010-10-04'),
(5, 5, 'Parachutes', '2000-07-10');


CREATE TABLE Genre(
genreID INT PRIMARY KEY,
genreName VARCHAR(50)
);

INSERT INTO Genre(genreID, genreName) VALUES
(1, 'Pop'),
(2, 'Rock'),
(3, 'Jazz');


CREATE TABLE MediaTypes(
mediaTypeID INT PRIMARY KEY,
mediaTypeName VARCHAR(50)
);

INSERT INTO MediaTypes(mediaTypeID, mediaTypeName) VALUES
(1, 'MP3'),
(2, 'WAV'),
(3, 'AAC');

CREATE TABLE Tracks(
trackID INT PRIMARY KEY,
albumID INT,
genreID INT,
mediaTypeID INT,
trackName VARCHAR(255),
CONSTRAINT fk_Tracks_Albums
     FOREIGN KEY (albumID) REFERENCES Albums(albumID),
CONSTRAINT fk_Genre_Tracks
     FOREIGN KEY (genreID) REFERENCES Genre(genreID),
CONSTRAINT fk_MediaTypes_Tracks
     FOREIGN KEY (mediaTypeID) REFERENCES MediaTypes(mediaTypeID)
);

INSERT INTO Tracks(trackID, albumID, genreID, mediaTypeID, trackName) VALUES
(1, 1, 1, 1, 'Rolling in the Deep'),
(2, 2, 1, 3, 'Shape of You'),
(3, 3, 1, 2, 'Blank Space'),
(4, 4, 3, 1, 'Just the Way You Are'),
(5, 5, 2, 2, 'Yellow');

ALTER TABLE Tracks
ADD amount DECIMAL(10,2);

UPDATE Tracks
SET amount = 2.0
WHERE trackID = 1;

UPDATE Tracks
SET amount = 0.77
WHERE trackID = 2;

UPDATE Tracks
SET amount = 2.00
WHERE trackID = 3;

UPDATE Tracks
SET amount = 1.00
WHERE trackID = 4;

UPDATE Tracks
SET amount = 0.88
WHERE trackID = 5;

CREATE TABLE Playlists(
playlistID INT PRIMARY KEY,
playlistName VARCHAR(255)
);

INSERT INTO Playlists(playlistID, playlistName) VALUES
(1, 'Top Hits'),
(2, 'Relax'),
(3, 'Workout'),
(4, 'Romantic'),
(5, 'Chill Vibes');

CREATE TABLE PlaylistTracks(
playlistTrackID INT PRIMARY KEY,
playlistID INT,
trackID INT,
CONSTRAINT fk_PlaylistTracks_Playlists
     FOREIGN KEY (playlistID) REFERENCES Playlists(playlistID),
CONSTRAINT fk_PlaylistTracks_Tracks
     FOREIGN KEY (trackID) REFERENCES Tracks(trackID)
);

INSERT INTO PlaylistTracks(playlistTrackID, playlistID, trackID) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 3, 4),
(5, 4, 5);

CREATE TABLE Customers(
customerID INT PRIMARY KEY,
customerName VARCHAR(100),
email VARCHAR(255)
);

INSERT INTO Customers(customerID, customerName, email) VALUES
(1, 'Nguyen Van A', 'a@example.com'),
(2, 'Tran Thi B', 'b@example.com'),
(3, 'Le Van C', 'c@example.com'),
(4, 'Pham Thi D', 'd@example.com'),
(5, 'Hoang Van E', 'e@example.com');

CREATE TABLE Employees(
employeeID INT PRIMARY KEY,
employeeName VARCHAR(100)
);

INSERT INTO Employees(employeeID, employeeName) VALUES
(1, 'John Smith'),
(2, 'Emily Davis'),
(3, 'Michael Johnson'),
(4, 'Sarah Wilson'),
(5, 'David Brown');

CREATE TABLE Invoices(
invoiceID INT PRIMARY KEY,
customerID INT,
invoiceNumber INT,
CONSTRAINT fk_Invoices_Customers
     FOREIGN KEY (customerID) REFERENCES Customers(customerID)
);

INSERT INTO Invoices(invoiceID, customerID, invoiceNumber) VALUES
(1, 1, 1001),
(2, 2, 1002),
(3, 3, 1003),
(4, 4, 1004),
(5, 5, 1005);

CREATE TABLE InvoiceLines(
InvoiceLineID INT PRIMARY KEY,
invoiceID INT,
playlistTrackID INT,
CONSTRAINT fk_InvoiceLines_Invoices
     FOREIGN KEY (invoiceID) REFERENCES Invoices(invoiceID),
CONSTRAINT fk_InvoiceLines_PlaylistTracks
     FOREIGN KEY (playlistTrackID) REFERENCES PlaylistTracks(playlistTrackID)
);

INSERT INTO InvoiceLines(InvoiceLineID, invoiceID, playlistTrackID) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

-- View_Track_Details: Tạo một VIEW kết hợp các bảng Track, Album, và Artist để hiển thị thông tin chi tiết về các bài hát có giá lớn hơn 0.99.

DROP VIEW View_Track_Details;

CREATE VIEW View_Track_Details
AS
SELECT 
trackID,
artistName AS 'TEN NGHE SI', 
albumName AS 'TEN ALBUM',
trackName AS 'TNE BAI HAT',
(SELECT amount WHERE amount >0.99) AS 'GIA'
FROM Artists ar
JOIN Albums a
ON ar.artistID = a.artistID
JOIN Tracks t
ON a.albumID = t.albumID
WHERE amount >0.99
GROUP BY trackID;

SELECT*FROM View_Track_Details;

-- idx_Track_Name: Tạo một BTREE INDEX trên cột Name trong bảng Track để tối ưu hóa tìm kiếm bài hát theo tên.

CREATE INDEX idx_Track_Name
ON Tracks(trackName);

SHOW INDEX FROM Tracks;

