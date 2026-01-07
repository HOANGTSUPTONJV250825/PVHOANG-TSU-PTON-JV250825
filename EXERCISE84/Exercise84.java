package EXERCISE84;

public class Exercise84 {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("B001",500000.00,"pham van hoang","0987654321");
        BankAccount bankAccount2 = new BankAccount("B002", 1000000.00,"tran van tam","058498339432");
        // chuyen tien tu bankAccount1 sang bankAccount2:
        double transaction = 300000;
        bankAccount1.withdraw(transaction);
        bankAccount2.deposit(transaction);
        bankAccount1.displayBalance();
        bankAccount2.displayBalance();
        System.out.println("pham van hoang da gui tien:"+transaction);
        System.out.println("Tran van tam da nhan tien:"+transaction);
    }
}
