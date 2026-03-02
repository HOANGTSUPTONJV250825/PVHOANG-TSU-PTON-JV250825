package com.example.library.Model.entity;

import jakarta.persistence.*;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
@Entity
@Table(name = "borrow_ticket")
public class BorrowTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String studentName;
    private LocalDate borrowDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private book book;

    public BorrowTicket() {
    }

    public BorrowTicket(long id, String studentName, LocalDate borrowDate, String status,book book) {
        this.id = id;
        this.studentName = studentName;
        this.borrowDate = borrowDate;
        this.status = status;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public book getBook() {
        return book;
    }

    public void setBook(book book) {
        this.book = book;
    }
}
