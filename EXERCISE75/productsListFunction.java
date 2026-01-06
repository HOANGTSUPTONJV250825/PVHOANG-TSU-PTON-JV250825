package EXERCISE75;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class productsListFunction {
    static List<product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("MENU:");
            System.out.println("1: them moi san pham: ");
            System.out.println("2: hien thi danh sach san pham: ");
            System.out.println("3: cap nhat san pham: ");
            System.out.println("4: xoa san pham: ");
            System.out.println("5: thoat");
            System.out.println("nhap vao lua chon cua ban: ");
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    products.add(createNewProduct());
                    break;
                case 2:
                    showInfor();
                    break;
                case 3:
                    updateInfor();
                    break;
                case 4:
                    deleteInfor();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("gia tri khong hop le");
            }
        }while (choose!=5);

    }
    public static product createNewProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("hay nhap vao ma san pham: ");
        String ID = sc.nextLine();
        System.out.println("hay nhap vao ten san pham: ");
        String name = sc.nextLine();
        System.out.println("hay nhap vao gia san pham: ");
        double price = sc.nextDouble();
        product newProduct = new product(ID,name,price);
        return newProduct;

    }
    public static void showInfor() {
        if (products.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        for (product p : products) {
            System.out.println(p);
        }
    }
    public static void updateInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma san pham can cap nhat: ");
        String msp = sc.nextLine();
        for (product findOut: products){
            if (findOut.getID().equals(msp)){
                System.out.println("nhap vao ten moi cho san pham:");
                findOut.setName(sc.nextLine());
                System.out.println("nhap vao gia moi cho san pham:");
                findOut.setPrice(sc.nextDouble());
            }
        }
        System.out.println("khong tim thay san pham!!");
    }

    public static void deleteInfor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma san pham can xoa: ");
        String msp = sc.nextLine();

        boolean removed = products.removeIf(p -> p.getID().equals(msp));

        if (removed) {
            System.out.println("Xoa san pham thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham!!");
        }
    }


}
