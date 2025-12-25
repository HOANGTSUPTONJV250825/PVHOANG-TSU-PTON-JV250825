package EXERCISE53;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise53 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao chuoi ky tu mong muon: ");
        String chuoi = sc.nextLine();
        String replaceStr = chuoi.replaceAll("[0-9]", "*");
        System.out.println(replaceStr);

    }
}
