package EXERCISE54;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise54 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao email: ");
        String email = sc.nextLine();
        email = email.replaceAll("//s+","");
        Pattern regex = Pattern.compile("^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$");
        Matcher matcher = regex.matcher(email);
        if (matcher.matches()){
            System.out.println("email hop le");
        }
        else {
            System.out.println("email khong hop le");
        }


    }
}
