package EXERCISE141;

import java.util.Scanner;

public class Students {
    private int ID;
    private String Name;
    private int Age;

    public Students() {
    }

    public Students(int ID, String name, int age) {
        this.ID = ID;
        Name = name;
        Age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void addStudents(Scanner sc){
        System.out.println("nhap vao ten hoc sinh:");
        this.Name = sc.nextLine();
        System.out.println("nhap vao tuoi hoc sinh:");
        this.Age = Integer.parseInt(sc.nextLine());
    }

    public void DislayInfor(){
        System.out.println("So thu tu: "+this.ID);
        System.out.println("ho va ten: "+this.Name);
        System.out.println("tuoi: "+this.Age);
    }
}
