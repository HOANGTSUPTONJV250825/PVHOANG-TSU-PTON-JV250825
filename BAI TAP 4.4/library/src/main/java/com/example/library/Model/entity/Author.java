package com.example.library.Model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorID;
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String authorName;

    private String authorEmail;

    @OneToMany(mappedBy = "author",
               cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<book> books = new ArrayList<>();

    public Author() {
    }

    public Author(long authorID, String authorName, String authorEmail) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
