package EXERCISE114;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class input {
    public static Map<Integer, Product> productList = productList = new HashMap<>();

    public static void addProduct(int ID, Product product){
        productList.put(ID, product);
        System.out.println("theme moi san pham thanh cong!!");
    }

    public static void updateProduct(int ID, Product product){
        int newID = -1;
       for (Map.Entry<Integer,Product> entry : productList.entrySet()){
           if (ID == entry.getValue().getID()){
               newID = entry.getValue().getID();
           }
       }
       if (newID == -1){
           System.err.println("ID not found");
       }else {
           productList.put(ID,product);
       }


    }

    public static void delProduct(int ID){
        int newID = -1;
        for (Map.Entry<Integer,Product> entry : productList.entrySet()){
            if (ID == entry.getValue().getID()){
                newID = entry.getValue().getID();
            }
        }
        if (newID == -1){
            System.err.println("ID not found");
        }else {
            productList.remove(ID);
            System.out.println("Delete finished");
        }
    }

    public static void displayProducts(){
        for (Map.Entry<Integer,Product>entry : productList.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().toString());
        }
    }

    public static void sortProductsPerUp100(){
        for (Map.Entry<Integer,Product>entry : productList.entrySet()){
            if (entry.getValue().getPrice()>=100000.00){
                System.out.println("san pham co gia tien lon hon 100 la: "+entry.getKey() +":"+entry.getValue().toString());
            }
        }
    }

    public static void sumPriceProduct(){
        double sum = 0;
        for (Map.Entry<Integer,Product> entry : productList.entrySet()){
            sum = sum + entry.getValue().getPrice();
        }
        System.out.println("tong gia tri san pham: "+sum);
    }

}
