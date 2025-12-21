package exercise03;

import java.util.Scanner;

public class Execise03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ban kinh hinh tron: ");
        double r = sc.nextDouble();
        sc.nextLine();
        double A = Math.PI*(r*r);
        System.out.printf("dien tich hinh tron co ban kinh %.2f la: %.2f",r,A);
    }
}
