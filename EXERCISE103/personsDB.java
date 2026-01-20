package EXERCISE103;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class personsDB implements IPersons{
    private List<person> listPersons;
    Scanner sc = new Scanner(System.in);
    person ps1;

    public personsDB() {
        listPersons = new LinkedList<>();
    }

    public static boolean isValidEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    @Override
    public void addPersons() {
        String name;
        String email;
        int phone;
        do {
            try{
                System.out.println("nhap vao ten nguoi dung:");
                name = sc.nextLine();
                if (name.isEmpty()){
                    throw new Exception("khong duoc de trong");
                }
                break;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }while (true);

        do {
            try{
                System.out.println("nhap vao eamail nguoi dung:");
                email = sc.nextLine();
                if (!isValidEmail(email)){
                    throw new Exception("Email khong dung dinh dang");
                }
                break;
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (true);

        do {
            try {
                System.out.println("nhap vao so dien thoai ngui dung:");
                phone = Integer.parseInt(sc.nextLine());
                if (phone < 0){
                    throw new Exception("so dien thoai khong dung dinh dang");
                }
                break;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);
         ps1 = new person(name,email,phone);
         listPersons.add(ps1);
    }

    @Override
    public void delPersons(String delEmail) {
        for (person p:listPersons){
            if (p.getEmail().equals(delEmail)){
                listPersons.remove(p);
            }
            else {
                System.err.println("email khong dung, vui long nhap lai!!!");
            }
        }
    }

    @Override
    public void disPlayPersons() {
        for (person ps:listPersons){
            System.out.println(ps.toString());
        }

    }
}
