package EXERCISE51;

import java.util.Scanner;

public class Exercise51 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao chuoi ky tu: ");
        String chuoi = sc.nextLine();
        System.out.println("nhap vao ky tu can tim");
        String kyTu = sc.nextLine();
        int index = chuoi.indexOf(kyTu);
        if (index == -1){
            System.out.println("khong tim thay tu "+kyTu+" trong chuoi");
        }
        else {
            System.out.println("tu "+kyTu+" xuat hien tai vi tri "+index+" trong chuoi");
        }

    }
}
