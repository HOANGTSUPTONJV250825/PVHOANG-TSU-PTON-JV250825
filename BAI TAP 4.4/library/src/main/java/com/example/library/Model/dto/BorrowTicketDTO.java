package com.example.library.Model.dto;

import java.time.LocalDate;

public class BorrowTicketDTO {
    private String studentName;
    private String bookTitle;
    private String authorName;
    private LocalDate borrowdate;

    public BorrowTicketDTO() {
    }

    public BorrowTicketDTO(String studentName, String bookTitle, String authorName, LocalDate borrowdate) {
        this.studentName = studentName;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.borrowdate = borrowdate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(LocalDate borrowdate) {
        this.borrowdate = borrowdate;
    }
}
