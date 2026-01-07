package EXERCISE81;

public class cat extends animal{
    private String fulColor;
    public cat(String name, int age, String fulColor){
        super(name,age);
        this.fulColor = fulColor;
    }
    @Override
    public void makeSound(){
        System.out.println("meo meo");
    }

    @Override
    public void displayInfor(){
        super.displayInfor();
        System.out.println("mau long: "+fulColor);
    }
}
