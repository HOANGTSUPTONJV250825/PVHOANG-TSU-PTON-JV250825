package Exercise24;

import java.util.Scanner;

public class Exercise24 {
    public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int age;

                do {
                    System.out.print("Nhap tuoi: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Vui long nhap vao mot so nguyen va lon hon 0");
                        sc.next();
                        age = -1;
                    } else {
                        age = sc.nextInt();
                        if (age <= 0) {
                            System.out.println("Vui long nhap vao mot so nguyen va lon hon 0");
                        }
                    }

                } while (age <= 0);

                System.out.println("Tuoi cua ban la " + age + " !");

    }
}
