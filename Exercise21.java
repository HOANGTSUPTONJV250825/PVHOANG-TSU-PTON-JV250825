package Exercise21;

import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mot so nguyen: ");
        int a = sc.nextInt();
        if (a == 0){
            System.out.println("so khong le cung khong chan");
        }
        else if (a % 2 == 0){
            System.out.println("so chan");
        }
        else {
            System.out.println("so le");
        }
    }
}
