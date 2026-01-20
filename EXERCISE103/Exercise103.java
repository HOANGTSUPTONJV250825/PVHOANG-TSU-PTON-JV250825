package EXERCISE103;

import java.util.Scanner;

public class Exercise103 {
    public static void main(String[] args) {
        personsDB psDB = new personsDB();
        Scanner sc = new Scanner(System.in);

                do {
                    System.out.println("======MENU======");
                    System.out.println("1. them thong tin nguoi dung.");
                    System.out.println("2. xoa thong tin nguoi dung.");
                    System.out.println("3. hien thi thong tin nguoi dung.");
                    System.out.println("4. thoat.");
                    System.out.println("nhap vao yeu cau mong muon:");
                    int choose;

                    try {
                        choose = Integer.parseInt(sc.nextLine());
                    }
                    catch (NumberFormatException e) {
                        System.err.println("nhap vao so nguyen tu 1 den 4");
                        continue;
                    }
                    switch (choose) {
                        case 1:
                            psDB.addPersons();
                            break;
                        case 2:
                                System.out.println("nhap vao email can xoa");
                                psDB.delPersons(sc.nextLine());
                            break;
                        case 3:
                            psDB.disPlayPersons();
                            break;
                        case 4:
                            System.exit(112);
                        default:
                            System.err.println("gia tri khong hop le");

                    }
                } while (true);
        }
}
