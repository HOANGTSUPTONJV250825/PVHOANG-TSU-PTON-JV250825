package com.example.library.Model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")

public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookID;
    private String title;
    private double price;
    @ManyToOne
    @JoinColumn(name = "author_ID")
    private Author author;
    @ManyToMany
    @JoinTable(name = "book_category",
              joinColumns = @JoinColumn(name = "book_id"),
              inverseJoinColumns = @JoinColumn(name = "category_ID"))
    private List<Category> category;

    public book() {
    }

    public book(long bookID, String title, double price) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;

    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
