package EXERCISE43;

import java.util.Scanner;

public class Exercise43 {
    public static void bubbleSort(int[] width){
        boolean needNextPass;
        int n = width.length;
        for (int k = 0; k < n - 1;k++){
            needNextPass = false;
            for (int i = 0; i < n - 1 - k; i++){
                if (width[i]<width[i+1]){
                    int temp = width[i];
                    width[i] = width[i+1];
                    width[i+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao chieu rong mang: ");
        int[] width = new int [sc.nextInt()];
        for (int i = 0; i < width.length; i++){
            System.out.println("nhap vao gia tri mang: ");
            width[i] = sc.nextInt();
        }
        System.out.println("gia tri truoc sap xep: ");
        for (int boforeSort: width){
            System.out.println(boforeSort);
        }
        bubbleSort(width);
        System.out.print("gia tri sau sap xep: [ ");
        for (int afterSort: width){
            System.out.print(afterSort+" ");
        }
        System.out.print("]");


    }
}
