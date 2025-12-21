package exercise02;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ten ban: ");
        String name = sc.nextLine();

        System.out.print("nhap vao tuoi cua ban: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("nhap vao que cua ban: ");
        String address = sc.nextLine();

        System.out.printf("Tên tôi là %s, tôi %s tuổi, hiện tại đang học tại PTIT-HCM. Quê ở %s",name,age,address);
    }
}
