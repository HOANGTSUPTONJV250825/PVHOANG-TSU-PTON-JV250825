package EXERCISE82;

public class bike extends vehicle{
    public bike(String name, int speed){
        super(name,speed);
    }
    @Override
    void displayInfor(){
        System.out.println("bike name: "+getName()+", speed: "+getSpeed());
    }
}
