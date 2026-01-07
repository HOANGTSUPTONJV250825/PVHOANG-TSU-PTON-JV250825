package EXERCISE84;

public class BankAccount implements Ibank{
    private String accountID;
    private double balance;
    private String userName;
    private String phoneNumber;
    public BankAccount(String accountID,double balance,String userName,String phoneNumber){
        this.accountID = accountID;
        this.balance = balance;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
    public String getAccountID(){
        return accountID;
    }
    public double getBalance(){
        return balance;
    }
    public String getUserName(){
        return userName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    @Override
    public void deposit(double amount){
         balance = balance + amount;
    }
    @Override
    public void withdraw(double amount){
        balance = balance - amount;
    }
    public void displayBalance(){
        System.out.println("so du tai khoan cua "+userName+" la: "+balance);
    }
}
