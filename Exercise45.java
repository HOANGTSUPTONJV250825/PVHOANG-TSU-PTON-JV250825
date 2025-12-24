package EXERCISE45;

import java.util.Scanner;

public class Exercise45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so hang cua chuoi: ");
        int hang = sc.nextInt();
        System.out.println("nhap vao so cot cua chuoi: ");
        int cot = sc.nextInt();
        int[][] width = new int [hang][cot];
        System.out.println("nhap vao gia tri chuoi: ");
        for (int i = 0; i < width.length; i++){
            for (int j = 0; j < width[i].length;j++){
                width[i][j] = sc.nextInt();
            }
        }
        int tongChan = 0;
        int tongLe = 0;
        for (int[] row: width){
            for (int value: row){
                if (value % 2 == 0){
                    tongChan = tongChan + value;
                }
                else {
                    tongLe = tongLe + value;
                }
            }
        }
        System.out.println("tong so chan cua mang: "+tongChan);
        System.out.println("tong so le cua mang: "+tongLe);
    }
}
