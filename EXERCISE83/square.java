package EXERCISE83;

public class square implements colorable{
    private double width;
    public square(double width){
        this.width = width;
    }
    public double getWidth(){
        return width;
    }
    @Override
    public void setColor(String color){
        System.out.println("Square color: "+color);
    }
}
