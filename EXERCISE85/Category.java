package EXERCISE85;

public class Category {
    private int ID;
    private String name;
    private String decription;
    public Category(){};
    public Category(int ID, String name, String decription){
        this.ID = ID;
        this.name = name;
        this.decription = decription;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getDecription(){
        return decription;
    }
    public void setID(int newID){
        ID = newID;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setDecription(String newDescription){
        decription = newDescription;
    }

}
