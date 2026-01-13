package EXERCISE101;

import java.util.Scanner;

public class Exercise101 {
    public static void main(String[] args) {
        inputDSSinhvien input = new inputDSSinhvien();
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
           input.addDSSinhvien();
            System.out.println("ban co muon them sinh vien khac? y/n:");
            choice = sc.nextLine();
        }while (choice.equalsIgnoreCase("y"));
        input.disPlayInfor();
        sc.close();
    }
}
