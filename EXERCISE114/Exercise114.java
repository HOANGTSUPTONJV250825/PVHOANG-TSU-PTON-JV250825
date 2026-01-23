package EXERCISE114;

import java.util.Scanner;

public class Exercise114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=============================MENU==========================");
            System.out.println("1. ADD product");
            System.out.println("2. Edit product");
            System.out.println("3. Delete product");
            System.out.println("4. Display product");
            System.out.println("5. Filter product (Price > 100)");
            System.out.println("6. Total Price of products");
            System.out.println("7. System out");
            System.out.println("please input your choice:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addProducts();
                    break;
                case 2:
                    updateProducts();
                    break;
                case 3:
                    DelProducts();
                    break;
                case 4:
                    input.displayProducts();
                    break;
                case 5:
                    input.sortProductsPerUp100();
                    break;
                case 6:
                    input.sumPriceProduct();
                    break;
                case 7:
                    System.exit(1);
                    break;
                default:
                    System.out.println("find not found");
            }
        }while (true);
    }
    public static void addProducts(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input product ID:");
        int ID = -1;
        try{
            ID = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.err.println("please input product ID like match Interger >= 0");
            return;
        }
        System.out.println("please input product Name: ");
        String name = "";
       try {
           name = sc.nextLine();
       }
       catch (Exception e){
           System.err.println("please input product name like String");
           return;
       }
        System.out.println("please input product Price: ");
        double price = 0.00;
      try {
          price = sc.nextDouble();
      }
      catch (Exception e){
          System.err.println("please input product price like double");
          return;
      }
        Product product = new Product(ID,name,price);
        input.addProduct(ID,product);
    }

    public static void updateProducts(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input product ID:");
        int newID = -1;
        try{
            newID = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.err.println("please input product ID like match Interger >= 0");
            return;
        }
        System.out.println("please input product Name: ");
        String newName = "";
        try {
            newName = sc.nextLine();
        }
        catch (Exception e){
            System.err.println("please input product name like String");
            return;
        }
        System.out.println("please input product Price: ");
        double newPrice = 0.00;
        try {
            newPrice = sc.nextDouble();
        }
        catch (Exception e){
            System.err.println("please input product price like double");
            return;
        }
        Product product = new Product(newID,newName,newPrice);
        input.updateProduct(newID,product);
    }

    public static void DelProducts(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input product ID need to delete:");
        int ID = Integer.parseInt(sc.nextLine());
        input.delProduct(ID);
    }
}
