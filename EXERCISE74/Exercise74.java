package EXERCISE74;

import java.util.Scanner;

public class Exercise74 {
    public static void main(String[] args) {
        students[] stus = new students[5];
        stus[0] = new students("hoang",12,"10A1", 9.5);
        stus[1] = new students("huy",12,"10A1", 5.5);
        stus[2] = new students("thu",12,"10A1", 6.5);
        stus[3] = new students("nga",12,"10A1", 4.5);
        stus[4] = new students("nghia",12,"10A1", 8.5);
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so diem nho nhat: ");
        double min = sc.nextDouble();
        System.out.println("nhap vao so diem cao nhat: ");
        double max = sc.nextDouble();
        System.out.println("danh sach sinh vien co diem tu "+min+" den "+max+" la:");
        for (students stu: stus){
            if (stu.getAvgScore()>=min && stu.getAvgScore()<=max){
                System.out.println(stu);
            }
        }
    }
}
