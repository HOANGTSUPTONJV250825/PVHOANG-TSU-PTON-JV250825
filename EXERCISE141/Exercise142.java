package EXERCISE141;

public class Exercise142 {
    public static void main(String[] args) {
        Students students = new Students(1,"Nguyen Van A",15);
        Students students1 = StudentsManager.findInfor(students.getID());
        if (students1 != null){
            StudentsManager.updateInfor(students);
            System.out.println("cap nhat thanh cong!!");
        }else {
            System.out.println("cap nhat that bai");
        }
    }
}
