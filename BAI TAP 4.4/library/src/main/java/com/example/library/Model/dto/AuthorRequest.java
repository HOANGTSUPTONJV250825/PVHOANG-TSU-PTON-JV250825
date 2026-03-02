package com.example.library.Model.dto;

public class AuthorRequest {
    private long authorid;
    private String authorname;
    private String authoremail;

    public AuthorRequest() {
    }

    public AuthorRequest(long authorid, String authorname, String authoremail) {
        this.authorid = authorid;
        this.authorname = authorname;
        this.authoremail = authoremail;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthoremail() {
        return authoremail;
    }

    public void setAuthoremail(String authoremail) {
        this.authoremail = authoremail;
    }
}
