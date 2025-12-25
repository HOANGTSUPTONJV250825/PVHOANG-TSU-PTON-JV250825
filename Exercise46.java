package EXERCISE46;

import java.util.Scanner;

public class Exercise46 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so hang: ");
        int row = sc.nextInt();
        System.out.println("nhap vao so cot: ");
        int col = sc.nextInt();
        int[][] width= new int [row] [col];
        System.out.println("nhap vao gia tri mang: ");
        for (int i = 0; i < width.length;i++){
            for (int j = 0; j < width[i].length; j++){
                width[i][j] = sc.nextInt();
            }
        }
        System.out.println("mang sau khi sap sep thu tu gian dan: ");
        for (int[] hang: width){
            selectionSort(hang);
            System.out.print("[");
            for (int value: hang){
                System.out.print(value+" ");
            }
            System.out.print("]\n");
        }
        System.out.println("nhap vao so can tim: ");
        int find = sc.nextInt();
        for (int[] hang: width){
            if (findOut(hang, find) != -1){
                System.out.println("tim kiem tuyen tinh: phan tu "+find+" tai vi tri "+findOut(hang,find));
            }

            }
        for (int[] hang1: width){
            if (binarySearch(hang1, find) != -1){
                System.out.println("tim kiem nhi phan: phan tu "+find+" tai vi tri "+binarySearch(hang1,find));
            }
        }

        }


    public static void selectionSort(int[] width){
        int n = width.length;
        for (int i = 0; i < n-1; i++){
            int minIndex = i;
            for (int j = i+1; j < n; j++){
                if (width[j]>width[minIndex]){
                    minIndex = j;
                }
            }
                int temp = width[minIndex];
                width[minIndex] = width[i];
                width[i] = temp;

        }
    }
    public static int findOut(int[] width, int key){
        for (int i = 0;i<width.length;i++){
            if (width[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] width, int key){
        int left = 0, right = width.length -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (width[mid] == key){
                return mid;
            }
            if (width[mid] > key){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
