package EXERCISE104;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceManager implements manage<student>{
    public List<student> students = new ArrayList<>();

     Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent(student item) {
        students.add(item);
    }

    @Override
    public void update(int index, student item) {
        students.set(index, item);
    }

    @Override
    public void delete(int index) {
        students.remove(index);
    }

    @Override
    public void display() {
        students.forEach(System.out::println);
    }
}
