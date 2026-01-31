package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private int StudentID;
    private String StudentName;
    private Date StudentDateOfBirth;
    private String StudentEmail;

    public Student() {
    }

    public Student(int studentID, String studentName, Date studentDateOfBirth, String studentEmail) {
        StudentID = studentID;
        StudentName = studentName;
        StudentDateOfBirth = studentDateOfBirth;
        StudentEmail = studentEmail;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Date getStudentDateOfBirth() {
        return StudentDateOfBirth;
    }

    public void setStudentDateOfBirth(Date studentDateOfBirth) {
        StudentDateOfBirth = studentDateOfBirth;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public void InputInfor(Scanner sc){
        System.out.println("nhap vao ten sinh vien:");
        this.StudentName = sc.nextLine();
        System.out.println("nhap vao ngay thang nam sinh(dd/mm/yyyy):");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            this.StudentDateOfBirth = sdf.parse(sc.nextLine());
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
        System.out.println("nhap vao email sinh vien:");
        this.StudentEmail = sc.nextLine();
    }

    public void DisplayInfor(){
        System.out.println("ID sinh vien: "+this.StudentID);
        System.out.println("Ten sinh vien: "+this.StudentName);
        System.out.println("Ngay sinh: "+this.StudentDateOfBirth);
        System.out.println("Email sinh vien: "+this.StudentEmail);
    }
}
