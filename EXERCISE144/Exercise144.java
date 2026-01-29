package EXERCISE144;

import java.util.List;
import java.util.Scanner;

public class Exercise144 {
    public static void main(String[] args) {
       if (BankingManager.transferFunds(2,1,7500000)){
           System.out.println("chuyen khoan thanh cong");
       }else {
           System.err.println("chuyen khoan that bai");
       }


    }
}
