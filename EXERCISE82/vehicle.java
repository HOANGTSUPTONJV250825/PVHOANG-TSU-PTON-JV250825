package EXERCISE82;

abstract class vehicle {
    private String name;
    private int speed;
    public vehicle(String name,int speed){
        this.name = name;
        this.speed = speed;
    }
    public String getName(){
        return name;
    }
    public int getSpeed(){
        return speed;
    }
    abstract void displayInfor();
    public void start(){
        System.out.println("vehicle is starting");
    }
}
