package EXERCISE56;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise56 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao mat khau: ");
        String mk = sc.nextLine();
        Pattern regex = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$");
        Matcher matcher = regex.matcher(mk);
        if (matcher.matches()){
            System.out.println("mat khau hop le");
        }
        else {
            System.out.println("mat khau khong hop le");
        }
    }
}
