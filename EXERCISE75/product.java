package EXERCISE75;

import java.util.Scanner;

public class product {
    private String ID;
    private String name;
    private double price;
    public product(String newID, String newName, double newPrice){
         this.ID = newID;
         this.name = newName;
         this.price = newPrice;
    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setID(String newID){
        ID = newID;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setPrice(double newPrice){
        price = newPrice;
    }
    @Override
    public String toString(){
        return  "|ma san pham: " +ID + "|ten san pham: " + name + "|gia: " + price + "| ";
    }
}
