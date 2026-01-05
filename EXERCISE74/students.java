package EXERCISE74;

public class students {
    private String name;
    private int age;
    private String Class;
    private double avgScore;
    public students(String newName, int newAge, String newClass, double newAvgScore){
        name = newName;
        age = newAge;
        Class = newClass;
        avgScore = newAvgScore;
    }
    public String getName(){
        return name;
    }
    public double getAvgScore(){
        return avgScore;
    }
    public String toString(){
        return  "Tên: " + name + ", Tuổi: " + age + ", Lớp: " + Class + ", Điểm trung bình: " + avgScore;
    }


}
