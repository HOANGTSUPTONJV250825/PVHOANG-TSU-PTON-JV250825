package EXERCISE81;

public class dog extends animal{
    private String breed;
    public dog(String name, int age, String breed){
        super(name,age);
        this.breed = breed;
    }
    @Override
    public void makeSound(){
        System.out.println("woof woof");
    }

    @Override
    public void displayInfor(){
        super.displayInfor();
        System.out.println("thuoc giong cho: "+breed);
    }


}
