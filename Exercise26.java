package Exercise26;

import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao day so: ");
        int a = sc.nextInt();
        if (a < 0){
            a = -a;
        }
        int N = 0;
        for (;a>0; a/=10){
            int i = a % 10;
            N=N+i;
        }
        System.out.println("tong cac chu so trong day so la: "+N);
    }
}
