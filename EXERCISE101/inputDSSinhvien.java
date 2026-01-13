package EXERCISE101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputDSSinhvien {
    private List<DSsinhvien> DSSinhvien;
    Scanner sc = new Scanner(System.in);
    public inputDSSinhvien() {
        DSSinhvien = new ArrayList<>();
    }
    public void addDSSinhvien(){
        System.out.println("nhap vao ten sinh vien:");
        String name;
        do {
               name = sc.nextLine();
                if(name.isEmpty()){
                    System.out.println("khong duoc de trong name");
                }else {
                    break;
                }
        }while (name.isEmpty());
        System.out.println("nhap vao tuoi sinh vien:");
        String age;
        do {
            age = sc.nextLine();
            try{
                if (age.isEmpty()){
                    System.out.println("khong duoc de trong tuoi!");
                }
                else if (Integer.parseInt(age) < 0){
                    System.out.println("tuoi khong duoc be hon khong");
                } else {

                    break;
                }
            }
            catch (Exception e){
                System.out.println("vui long nhap so nguyen lon hon 0 !");
            }
        }while (true);
        System.out.println("nhap vao diem trung binh:");
        String average;
        do {
            average = sc.nextLine();
            try {
                if (average.isEmpty()) {
                    System.out.println("khong duoc de trong diem trung binh:");
                }
                else if (Double.parseDouble(average) < 0) {
                    System.out.println("vui long nhap so thuc >= 0!");
                }
                else {
                    break;
                }
            }
            catch (Exception e){
                System.out.println("vui long nhap vao so thuc >= 0");
            }
        }while (true);
       DSsinhvien danhsachSV = new DSsinhvien(name,Integer.parseInt(age),Double.parseDouble(average));
        DSSinhvien.add(danhsachSV);
    }
    public void disPlayInfor(){
        if (DSSinhvien.isEmpty()){
            System.out.println("chua co du lieu");
        }
        else {
        for (DSsinhvien d: DSSinhvien) {
            System.out.println(d);
        }
        }
    }
}
