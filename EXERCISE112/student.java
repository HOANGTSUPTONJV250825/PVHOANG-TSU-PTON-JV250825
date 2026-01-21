package EXERCISE112;

public class student {
    private String name;
    private int age;
    private double grade;

    public student() {
    }

    public student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "|" +
                "name :        " + name + '|' +
                "age=" + age +
                "| grade=" + grade +
                '|';
    }
}

