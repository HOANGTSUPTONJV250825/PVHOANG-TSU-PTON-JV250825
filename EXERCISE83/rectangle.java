package EXERCISE83;

public class rectangle implements colorable {
    private double width;
    private double length;
    public rectangle(double width, double length){
        this.length = length;
        this.width = width;
    }
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
    @Override
    public void setColor(String color){
        System.out.println("Rectangle color: "+color);
    }
}
