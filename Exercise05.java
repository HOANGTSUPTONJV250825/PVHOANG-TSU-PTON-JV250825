package EXCERCISE05;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so a:");
        int a = sc.nextInt();
        System.out.println("nhap vao so b:");
        int b = sc.nextInt();
        System.out.println("nhap vao so c:");
        int c = sc.nextInt();
        System.out.println("nhap vao so d:");
        int d = sc.nextInt();
        int mau = b*d;
        int tu = a*d+b*c;
        System.out.println("Tổng của hai phân số: a⁄b + c⁄d = (ad + bc)⁄bd: " +tu+ "/" +mau );
    }
}
