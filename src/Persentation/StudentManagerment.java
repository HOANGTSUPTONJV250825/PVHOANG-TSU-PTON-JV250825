package Persentation;

import Business.StudentsManager;
import Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagerment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----------------MENU---------------------");
            System.out.println("1.hien thi danh sach");
            System.out.println("2.them moi sinh vien");
            System.out.println("3.sua thong tin sinh vien theo so ID");
            System.out.println("4.tim thong tin sinh vien qua so ID");
            System.out.println("5.xoa thong tin sinh vien qua so ID");
            System.out.println("6.hien thi danh sach theo ten");
            System.out.println("7.thoat");
            System.out.println("moi nhap vao lua chon:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    DisplayStudentInfor();
                    break;
                case 2:
                    AddStudentInfor(sc);
                    break;
                case 3:
                    UpdateInforStudents(sc);
                    break;
                case 4:
                    FindInforStudent(sc);
                    break;
                case 5:
                    DeleteInforStudents(sc);
                    break;
                case 6:
                    SearchInforStudentsByName(sc);
                    break;
                case 7:
                    System.exit(1);
                    break;
                default:
                    System.err.println("nhap vao so nguyen duong tu 1 den 7");
            }
        }while (true);
    }

    public static void DisplayStudentInfor(){
        List<Student> students = StudentsManager.findAll();
        System.out.println("thong tin bang quan ly sinh vien:");
        for (Student s : students){
            System.out.println("-----------------------------------------");
            s.DisplayInfor();
            System.out.println("-----------------------------------------");
        }

    }

    public static void AddStudentInfor(Scanner sc){
        Student student = new Student();
        student.InputInfor(sc);
        if (StudentsManager.AddStudents(student)){
            System.out.println("them moi sinh vien thanh cong");
        }else {
            System.err.println("them moi sinh vien that bai");
        }

    }

    public static void UpdateInforStudents(Scanner sc){
        System.out.println("nhap vao ID sinh vien can xoa: ");
        int inID = Integer.parseInt(sc.nextLine());
        Student student = StudentsManager.FindInforStudent(inID);
        if (student != null){
            student.InputInfor(sc);
            StudentsManager.updateInfor(student);
            System.out.println("cap nhat thanh cong thoong tin sinh vien");
        }else {
            System.err.println("cap nhat that bai");
        }
    }

    public static void FindInforStudent(Scanner sc){
        System.out.println("nhap vao ID sinh vien can tim:");
        int inID = Integer.parseInt(sc.nextLine());
        Student student = StudentsManager.FindInforStudent(inID);
        if (student != null){
            student.DisplayInfor();
        }else {
            System.err.println("khong tim thay infor sinh vien");
        }
    }

    public static void DeleteInforStudents(Scanner sc){
        System.out.println("nhap vao ID sinh vien can sua: ");
        int inID = Integer.parseInt(sc.nextLine());
        Student student = StudentsManager.FindInforStudent(inID);
        if (student != null){
            StudentsManager.deleteInfor(student);
            System.out.println("xoa thanh cong thoong tin sinh vien");
        }else {
            System.err.println("Xoa that bai");
        }
    }

    public static void SearchInforStudentsByName(Scanner sc){
        System.out.println("nhap vao ten sinh vien can tim: ");
        String inName = sc.nextLine();
        List<Student> students = StudentsManager.FindInforStudentByName(inName);
        System.out.println("thong tin bang quan ly sinh vien theo ten:");
        for (Student s : students){
            System.out.println("-----------------------------------------");
            s.DisplayInfor();
            System.out.println("-----------------------------------------");
        }


    }
}
