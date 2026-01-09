package EXERCISE86;

public class book {
    private String title;
    private String author;
    private String isbn;
    private int year;
    public book(String title,String author,String isbn,int year){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    public int getYear(){
        return year;
    }
    public void setTitle(String newTitle){
        title = newTitle;
    }
    public void setAuthor(String newAuthor){
        author = newAuthor;
    }
    public void setIsbn(String newIsbn){
        isbn = newIsbn;
    }
    public void setYear(int newYear){
        year = newYear;
    }
    public String getDetail(){
        return "ten sach: "+title+" | tac gia: "+author+" | ISBN: "+isbn+" | xuat ban nam: "+year;
    }
}
