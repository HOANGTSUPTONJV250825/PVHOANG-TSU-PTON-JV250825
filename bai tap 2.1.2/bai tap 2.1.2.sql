CREATE DATABASE bookStore;

USE bookStore;

CREATE TABLE Author (
    AuthorID INT AUTO_INCREMENT PRIMARY KEY,
    AuthorName VARCHAR(100) NOT NULL,
    BirthDate DATE,
    Country VARCHAR(100)
    );
    
CREATE TABLE Publisher (
    PublisherID INT AUTO_INCREMENT PRIMARY KEY,
    PublisherName VARCHAR(150) NOT NULL,
    Address VARCHAR(200),
    Phone VARCHAR(20)
);

CREATE TABLE Book (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(200) NOT NULL,
    PublicationYear YEAR,
    ISBN VARCHAR(20) UNIQUE,
    AuthorID INT NOT NULL,
    PublisherID INT NOT NULL,
    
    CONSTRAINT fk_book_author
        FOREIGN KEY (AuthorID)
        REFERENCES Author(AuthorID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_book_publisher
        FOREIGN KEY (PublisherID)
        REFERENCES Publisher(PublisherID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);




