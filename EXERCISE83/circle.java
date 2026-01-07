package EXERCISE83;

public class circle implements colorable{
    private double radius;
    public circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    @Override
    public void setColor(String color){
        System.out.println("Circle color: "+color);
    }
}
