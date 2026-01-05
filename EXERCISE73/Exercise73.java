package EXERCISE73;

import java.util.Scanner;

public class Exercise73 {
    public static void main(String[] args) {
        person person1 = new person();
        person person2 = new person();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ten nguoi dau tien: ");
        person1.setName(sc.nextLine());
        System.out.println("nhap vao tuoi nguoi dau tien: ");
        person1.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("nhap vao ten nguoi thu hai: ");
        person2.setName(sc.nextLine());
        System.out.println("nhap vao tuoi nguoi thu hai: ");
        person2.setAge(sc.nextInt());
        if (person1.getAge()>person2.getAge()){
            System.out.println("tuoi "+person1.getName()+" lon hon tuoi "+person2.getName());
        }
        else if (person1.getAge() == person2.getAge()){
            System.out.println("tuoi "+person1.getName()+" bang tuoi "+person2.getName());
        }
        else {
            System.out.println("tuoi "+person1.getName()+" nho hon tuoi "+person2.getName());
        }


    }
}
