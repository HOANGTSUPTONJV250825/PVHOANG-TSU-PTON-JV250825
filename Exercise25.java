package Exercise25;

import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao thang: ");
        int thang = sc.nextInt();
        switch (thang){
            case 1:
                System.out.println("so ngay cua thang 1 la 31");
                break;
            case 2:
                System.out.println("so ngay cua thang 2 la 28");
                break;
            case 3:
                System.out.println("so ngay cua thang 3 la 31");
                break;
            case 4:
                System.out.println("so ngay cua thang 4 la 30");
                break;
            case 5:
                System.out.println("so ngay cua thang 5 la 31");
                break;
            case 6:
                System.out.println("so ngay cua thang 6 la 30");
                break;
            case 7:
                System.out.println("so ngay cua thang 7 la 31");
                break;
            case 8:
                System.out.println("so ngay cua thang 8 la 31");
                break;
            case 9:
                System.out.println("so ngay cua thang 9 la 30");
                break;
            case 10:
                System.out.println("so ngay cua thang 10 la 31");
                break;
            case 11:
                System.out.println("so ngay cua thang 11 la 30");
                break;
            case 12:
                System.out.println("so ngay cua thang 12 la 31");
                break;
            default:
                System.out.println("thang khong hop le");
        }
    }
}
