package Exercise23;

import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao mot so nguyen duong:");
        int N = sc.nextInt();
        if (N <= 0){
            System.out.println("so khong hop le");
        }
        else {
            int a = 0;
            for (int i = 1; i <= N; i++) {
                a = a + i;
            }
            System.out.println("tong cac so tu 1 den " +N+ " la:"+a);
        }

    }
}
