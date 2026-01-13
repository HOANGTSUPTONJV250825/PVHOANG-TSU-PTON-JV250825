package EXERCISE102;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class booksManager implements IBooks{
    private Map<String,book> booksList;
    Scanner sc = new Scanner(System.in);

    public booksManager() {
        this.booksList = new HashMap<>();
    }

    @Override
    public void addBooks(){
        System.out.println("nhap vao ten sach:");
        String name;
        do {
            name = sc.nextLine();
            if (name.isEmpty()){
                System.err.println("khong duoc de trong!");
            }
            else {
                break;
            }
        }while (name.isEmpty());
        System.out.println("nhap vao ten tac gia:");
        String author;
        do {
            author = sc.nextLine();
            try{
                if (author.isEmpty()){
                    throw new Exception("khong duoc de trong ten tac gia!");
                }
                else {
                    for (int i = 0;i<author.length();i++){
                        char c = author.charAt(i);
                        if (!Character.isLetter(c) && c!=' '){
                            throw new Exception("ten tac gia chi duoc chua chu cai, loi tai ky tu: "+c);
                        }
                    }
                }
                break;
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (true);
        System.out.println("nhap vao nam xuat ban:");
        String year;
        do {
            year = sc.nextLine();
            try{
                if (year.isEmpty()){
                    System.err.println("khong duoc de trong nam xuat ban:");
                } else if (Integer.parseInt(year)<=0) {
                    System.err.println("nam xuat ban phai lon hon 0!");
                }else {
                    break;
                }
            }
            catch (Exception e){
                System.err.println("nhap vao nam xuat ban la so nguyen lon hon 0!");
            }
        }while (true);
        book newBook = new book(name,author,Integer.parseInt(year));
        booksList.put(newBook.getName(),newBook);
    }

    @Override
    public void disPlayInfor(){
        if (booksList.isEmpty()){
            System.out.println("chua co du lieu");
        }else {
            for (Map.Entry<String,book> b: booksList.entrySet()){
                System.out.println(b.getValue());
            }
        }
    }

    @Override
    public void findBook(){
        System.out.println("nhap vao ten sach can tim:");
        String findName;
        do {
            findName = sc.nextLine();
            if (findName.isEmpty()){
                System.err.println("khong duoc de trong ");
            }
            else{
                break;
            }
        }while (true);
        if (booksList.containsKey(findName) == true){
            System.out.println(booksList.get(findName));
        }else {
            System.err.println("khong tim thay sach");
        }
    }
}
