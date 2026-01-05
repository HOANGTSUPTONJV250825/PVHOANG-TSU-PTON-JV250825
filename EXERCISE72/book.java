package EXERCISE72;

public class book {
    private String title;
    private String author;
    private double price;
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public void setTitle(String newTitle){
        title = newTitle;
    }
    public void  setAuthor(String newAuthor){
        author = newAuthor;
    }
    public void setPrice(double newPrice){
        if (newPrice >= 0){
            price = newPrice;
        }
        else {
            System.out.println("gia thay doi khong hop le");
        }
    }
}
