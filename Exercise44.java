package EXERCISE44;

import java.util.Scanner;

public class Exercise44 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao chieu rong mang:");
        int[] width = new int [sc.nextInt()];
        if (width.length <= 0){
            System.out.println("kich thuoc rong");
            return;
        }
        else {
            int n = width.length;
            System.out.println("nhap vao gia tri mang:");
            for (int i = 0; i < width.length; i++){
                width[i] = sc.nextInt();
            }
            System.out.println("mang truoc sap sep: [");
            for (int beforeSort: width){
                System.out.print(beforeSort+" ");
            }
            System.out.println("]");
            for (int j = 0;j < n/2;j++){
                int temp = width[j];
                width[j] = width[n-1-j];
                width[n-1-j] = temp;
            }

            System.out.println("mang sau dao nguoc: [");
            for (int afterSort: width){
                System.out.print(afterSort+" ");
            }
            System.out.println("]");
        }
    }
}
