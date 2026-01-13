package EXERCISE101;

public class DSsinhvien {
    private String Name;
    private int Age;
    private double Average;
    public DSsinhvien(String Name,int Age,double Average){
        this.Name = Name;
        this.Age = Age;
        this.Average = Average;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public double getAverage() {
        return Average;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setAverage(double average) {
        Average = average;
    }

    @Override
    public String toString() {
        return "DSsinhvien{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Average=" + Average +
                '}';
    }
}
