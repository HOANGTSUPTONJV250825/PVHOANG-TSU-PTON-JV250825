package EXERCISE141;

import java.util.List;
import java.util.Scanner;

public class Exercise143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so tuoi can xoa: ");
        int delAge = Integer.parseInt(sc.nextLine());
        List<Students> students = StudentsManager.findAll();
        int cout = 0;
        for (Students S : students){
            if (S.getAge()<delAge){
                cout = cout+1;
            }
            StudentsManager.delStudent(delAge);

        }
        if (cout == 0){
            System.out.println("khong co hoc sinh nao co tuoi < "+delAge);
        }else {
            System.out.println("co "+cout+" hoc sinh co tuoi nho hon "+delAge);
        }

    }
}
