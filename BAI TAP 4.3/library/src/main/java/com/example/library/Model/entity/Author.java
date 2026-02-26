package com.example.library.Model.entity;

public class Author {
    private int authorID;
    private String authorName;
    private String authorEmail;

    public Author() {
    }

    public Author(int authorID, String authorName, String authorEmail) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
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
