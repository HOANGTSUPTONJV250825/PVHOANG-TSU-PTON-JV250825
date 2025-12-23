package EXERCISE06;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao chieu dai:");
        double chieuDai = sc.nextDouble();
        System.out.println("nhap vao chieu rong:");
        double chieuRong = sc.nextDouble();
        double chuVi = (chieuDai + chieuRong)*2;
        double dienTich = chieuDai * chieuRong;
        System.out.println("chu vi hinh chu nhat la:" +chuVi);
        System.out.println("dien tich hinh chu nhat la:" +dienTich);
    }
}
