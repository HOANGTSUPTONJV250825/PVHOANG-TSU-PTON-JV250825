package com.example.product_management.sevice;

import com.example.product_management.model.products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class productSevice {
    private List<products>products = new ArrayList<>();

    public productSevice(){
        products.add(new products(1,"ipad",4000000));
        products.add(new products(2,"iphone 17",16000000));
        products.add(new products(3,"ipod",5000000));
    }

    public List<products> getAllProducts(){
        return products;
    }

    public products addProduct(products product){
        products.add(product);
        return product;
    }

    public products updateProduct(int ID, products newProduct){
        for (products p: products){
            if (p.getProductID() == ID){
                p.setProductName(newProduct.getProductName());
                p.setPrice(newProduct.getPrice());
                return p;
            }
        }
        return null;
    }

    public boolean deleteProduct(int ID){
        return products.removeIf(p->p.getProductID() == ID);
    }


}
