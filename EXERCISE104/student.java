package EXERCISE104;

public class student {
    private int ID;
    private String Name;

    public student(){
    }

    public student(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "student{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
