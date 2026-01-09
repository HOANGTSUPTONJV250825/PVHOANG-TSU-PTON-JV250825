package EXERCISE85;

import java.util.Scanner;

public class Exercise85 {
    public static void main(String[] args) {
        CategoryManager cm = new CategoryManager();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("MENU");
            System.out.println("1.them danh muc:");
            System.out.println("2.hien thi danh muc:");
            System.out.println("3.cap nhat danh muc:");
            System.out.println("4.xoa danh muc:");
            System.out.println("5.thoat");
            System.out.println("nhap vao danh muc muon thuc hien:");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    System.out.println("nhap vao ID danh muc:");
                    int newID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("nhap vao ten danh muc moi:");
                    String newName = sc.nextLine();
                    System.out.println("nhap vao mo ta danh muc moi:");
                    String newDescription = sc.nextLine();
                    Category category = new Category(newID,newName,newDescription);
                    cm.addCategory(category);
                    break;
                case 2:
                    System.out.println("danh sach danh muc:");
                    for (Category c : cm.findAll()) {
                        System.out.println(c.getID() + " | " + c.getName() + " | " + c.getDecription());
                    }
                    break;
                case 3:
                    System.out.println("nhap vao ID thong tin can cap nhat:");
                    int ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("nhap ten moi:");
                    String  newName1 = sc.nextLine();
                    System.out.println("nhap mo ta moi: ");
                    String  newDescription1 = sc.nextLine();
                    Category category1 = new Category(ID,newName1,newDescription1);
                    cm.updateCategory(category1);
                    break;
                case 4:
                    System.out.println("nhap vao ID danh muc can xoa:");
                    int findID = sc.nextInt();
                    sc.nextLine();
                    cm.deleteByID(findID);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("gia tri khong hop le");
            }
        }while (choose!=5);
    }
}
