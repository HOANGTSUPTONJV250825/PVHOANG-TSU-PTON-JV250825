package EXERCISE42;

import java.util.Scanner;

public class Exercise42 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao chieu rong mang:");
        int[] width = new int [sc.nextInt()];
        for (int i = 0;i<width.length;i++){
            System.out.println("nhap vao gia tri mang: ");
            width[i] = sc.nextInt();
        }
        int sum = 0;
        for (int value: width){
            sum += value;
        }
        System.out.println("tong cac phan tu trong mang la: "+sum);

    }
}
