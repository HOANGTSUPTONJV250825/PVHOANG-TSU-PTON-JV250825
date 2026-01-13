package EXERCISE102;

import java.util.Scanner;

public class Exercise102 {
    public static void main(String[] args) {
        booksManager bm = new booksManager();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*************MENU QUAN LY SACH*************");
            System.out.println("1. them sach");
            System.out.println("2. tim kiem sach");
            System.out.println("3. hien thi danh sach");
            System.out.println("4. thoat");
            System.out.println("nhap vao lua chon cua ban:");
            String choice;
            do {
                choice = sc.nextLine();
                try{
                    if (choice.isEmpty()){
                        System.err.println("khong duoc de trong");
                    } else if (Integer.parseInt(choice)<0) {
                        System.err.println("gia tri nhap vao phai la so nguyen duong !!!");

                    } else {
                        break;
                    }
                }
                catch (Exception e){
                    System.err.println("gia tri nhap vao phai la so nguyen duong !!!");
                }
            }while (true);
            switch (Integer.parseInt(choice)){
                case 1:
                    bm.addBooks();
                    break;
                case 2:
                    bm.findBook();
                    break;
                case 3:
                    bm.disPlayInfor();
                    break;
                case 4:
                    System.exit(113);
                    break;
                default:
                    System.err.println("gia tri khong hop le!!!");
            }

        }while (true);
    }
}
