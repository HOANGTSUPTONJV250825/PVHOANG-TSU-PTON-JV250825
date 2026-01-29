package EXERCISE144;

public class Banking {
    private int ID;
    private double Balance;

    public Banking() {
    }

    public Banking(int ID, double balance) {
        this.ID = ID;
        Balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
