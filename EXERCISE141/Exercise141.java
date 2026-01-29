package EXERCISE141;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentsManager manager = new StudentsManager();
        List<Students> students = Arrays.asList(
                new Students(0,"Nguyen Van A", 17),
                new Students(0,"Nguyen Van B", 17),
                new Students(0,"Nguyen Van C", 17)
        );
        AddStudents(sc);

    }

    public static void AddStudents(Scanner sc){
        System.out.println("nhap vao thong tin hoc sinh:");
        Students students = new Students();
        students.addStudents(sc);
        if (StudentsManager.addStudent(students)){
            System.out.println("them moi hoc sinh thanh cong");
        }else {
            System.err.println("them moi hoc sinh that bai");
        }
    }
}
