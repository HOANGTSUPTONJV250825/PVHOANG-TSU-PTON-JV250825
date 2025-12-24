package EXERCISE41;

import java.util.Scanner;

public class Exercise41 {
    public static void selectionSort(int[] width){
        int n = width.length;
        for (int i = 0; i<n-1; i++){
            int minIndex = i;
            for (int j = i+1;j<n;j++){
                if (width[j]>width[minIndex]){
                    minIndex = j;
                }
            }
            int temp = width[minIndex];
            width[minIndex] = width[i];
            width[i] = temp;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao kich thuoc mang:");
        int[] width = new int[sc.nextInt()];
        for (int i = 0;i<width.length;i++){
            System.out.println("nhap vao gia tri mang: ");
            width[i] = sc.nextInt();
        }
        System.out.println("mang truoc sap xep: ");
        for (int beforeSort: width) {
            System.out.print(beforeSort + ",");
        }
        selectionSort(width);
        System.out.print("\nmang sau sap xep: \n");
        for (int afterSort: width){
            System.out.print(afterSort + ",");
        }
        System.out.println(" ");
        System.out.println("phan tu lon nhat la:" + width[0]);

    }
}
