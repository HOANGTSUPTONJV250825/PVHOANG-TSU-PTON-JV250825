package EXERCISE82;

public class car extends vehicle{
    public car(String name, int speed){
        super(name,speed);
    }
    @Override
    void displayInfor(){
        System.out.println("car name: "+getName()+", speed: "+getSpeed());
    }
}
