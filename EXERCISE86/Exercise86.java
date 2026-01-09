package EXERCISE86;

import java.util.Scanner;

public class Exercise86 {
    public static void main(String[] args) {
        bookManager bm = new bookManager();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("MENU");
            System.out.println("1.them sach");
            System.out.println("2.hien thi sach");
            System.out.println("3.xoa sach");
            System.out.println("4.thoat");
            System.out.println("nhap vao thao tac mong muon");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    System.out.println("nhap vao ten sach moi: ");
                    String newTitle = sc.nextLine();
                    System.out.println("nhap vao ten tac gia: ");
                    String newAuthor = sc.nextLine();
                    System.out.println("nhap vao ma ISBN:");
                    String newIsbn = sc.nextLine();
                    System.out.println("nhap vao nam xuat ban: ");
                    int newYear = sc.nextInt();
                    sc.nextLine();
                    book book = new book(newTitle,newAuthor,newIsbn,newYear);
                    bm.addBook(book);
                    break;
                case 2:
                    bm.displayBook();
                    break;
                case 3:
                    System.out.println("nhap vao ISBN sach can xoa: ");
                    String delIsbn = sc.nextLine();
                    bm.removeBook(delIsbn);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("yeu cau khong hop le");
            }
        }while (choose != 4);
    }
}
