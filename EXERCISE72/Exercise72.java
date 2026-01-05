package EXERCISE72;

public class Exercise72 {
    public static void main(String[] args){
        book myBook = new book();
        myBook.setTitle("nguoi khong phoi");
        myBook.setAuthor("Pham van A");
        myBook.setPrice(29.99);
        System.out.println("title: "+myBook.getTitle());
        System.out.println("author: "+myBook.getAuthor());
        System.out.println("price: "+myBook.getPrice());
        // thu thay doi gia thanh cong
        myBook.setPrice(35.55);
        System.out.println("gia moi: "+myBook.getPrice());
        // thu thay doi khong thanh cong
        myBook.setPrice(-5.00);

    }
}
