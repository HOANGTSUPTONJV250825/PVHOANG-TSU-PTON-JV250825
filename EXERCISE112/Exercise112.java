package EXERCISE112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercise112 {
    public static void main(String[] args) {
        List<student> listStudent = Arrays.asList(
                new student("Alice",20, 8.5),
                new student("Bob",22, 6.0),
                new student("Charlie",21, 7.5),
                new student("David",23, 9.0),
                new student("Eve",20, 5.5),
                new student("Frank",22, 8.0),
                new student("Grace",21, 7.0),
                new student("Heidi",23, 8.8),
                new student("Ivan",20, 6.5),
                new student("Ludy",21, 7.2)
        );
        System.out.println("danh sach sinh vien co diem lon hon 7.0, sap xep theo ten");
        List<student> listStudentHave7Up = listStudent.stream().filter(name -> name.getGrade() >= 7.0).sorted(Comparator.comparing(student::getName)).toList();
        listStudentHave7Up.forEach(System.out::println);
    }
}
