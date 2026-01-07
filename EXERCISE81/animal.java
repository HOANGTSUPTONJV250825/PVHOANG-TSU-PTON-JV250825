package EXERCISE81;

public class animal {
    private String name;
    private int age;
    public animal(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    public void displayInfor(){
        System.out.println("ban "+name+" co tuoi la "+age);
    }
    public void makeSound(){
        System.out.println("some generic sound");
    }
}
