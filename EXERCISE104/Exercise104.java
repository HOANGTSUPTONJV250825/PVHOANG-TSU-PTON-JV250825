package EXERCISE104;

import java.util.Scanner;

public class Exercise104 {
    public static void main(String[] args) {
        AttendanceManager am = new AttendanceManager();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("****************** MENU QUAN LY DIEM DANH ***********************");
            System.out.println("1. them sinh vien:");
            System.out.println("2. sua sinh vien: ");
            System.out.println("3. xoa sinh vien: ");
            System.out.println("4. hien thi danh sach sinh vien:");
            System.out.println("5. thoat");
            System.out.println("nhap vao lua chon:");
            int choose;
            try {
                choose = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.err.println("nhap vao so nguyen tu 1 den 5");
                continue;
            }
            switch (choose){
                case 1:
                    addstudent(am,sc);
                    break;
                case 2:
                    am.display();
                    updateInforStudent(am,sc);
                    break;
                case 3:
                    System.out.println("nhap vao ID sinh vien can xoa:");
                    int delID = -1;
                    try {
                        delID = Integer.parseInt(sc.nextLine());
                    }
                    catch (Exception e){
                        System.err.println("nhap vao so nguyen lon hon 0");
                    }
                    int index = -1;
                    for (int i = 0; i<am.students.size();i++){
                        if (am.students.get(i).getID() == delID){
                            index = i;
                            break;
                        }
                    }
                    if (index == -1){
                        System.err.println("khong tim thay id sinh vien can xoa");
                    }
                    am.delete(index);
                    System.out.println("xoa hoan tat");
                    break;
                case 4:
                    am.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("nhap vao ky tu so tu 1-5!!!");
            }
        }while (true);
    }
    public static void addstudent(AttendanceManager am, Scanner sc){
        System.out.println("nhap vao ID sinh vien:");
        int ID = 0;
        try {
            ID = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.err.println("nhap vao so nguyen lon hon 0");
        }
        System.out.println("nhap vao ten sinh vien");
        String name = sc.nextLine();
        student item = new student(ID,name);
        am.addStudent(item);
    }
    public static void updateInforStudent(AttendanceManager am, Scanner sc){
        int newID = -1;
        try {
            System.out.println("nhap vao ID sinh vien can cap nhat:");
            newID = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.err.println("nhap vao so nguyen duong !!!");
        }
        System.out.println("nhap vao ten sinh vien can sua:");
        String newName = sc.nextLine();

        int index = -1;
        for (int i = 0; i < am.students.size();i++){
            if (am.students.get(i).getID() == newID){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.err.println("khong tim thay ID sinh vien");
        }

        student newStudent = new student(newID,newName);
        am.update(index,newStudent);
        System.out.println("update danh sach thanh cong");
        }



}
