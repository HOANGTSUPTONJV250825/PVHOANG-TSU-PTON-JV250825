package Exercise22;

import java.util.Scanner;

public class Exercise22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so nguyen tu 1 den 7");
        int a = sc.nextInt();
        switch (a){
            case 1:
                System.out.println("chu nhat");
                break;
            case 2:
                System.out.println("thu hai");
                break;
            case 3:
                System.out.println("thu ba");
                break;
            case 4:
                System.out.println("thu tu");
                break;
            case 5:
                System.out.println("thu nam");
                break;
            case 6:
                System.out.println("thu sau");
                break;
            case 7:
                System.out.println("thu bay");
                break;
            default:
                System.out.println("so nhap vao khong hop le");
        }
    }
}
