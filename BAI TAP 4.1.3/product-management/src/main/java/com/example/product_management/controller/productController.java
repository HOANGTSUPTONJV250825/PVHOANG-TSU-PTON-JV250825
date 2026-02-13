package com.example.product_management.controller;

import com.example.product_management.model.products;
import com.example.product_management.sevice.productSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productController {
    @Autowired
    private productSevice productSevice;

    @GetMapping
    public List<products> getProducts(){
        return productSevice.getAllProducts();
    }

    @PostMapping
    public products addProduct(@RequestBody products product){
        return productSevice.addProduct(product);
    }

    @PutMapping({"/{ID}"})
    public products updateProduct(@PathVariable int ID,@RequestBody products product){
        return productSevice.updateProduct(ID,product);
    }

    @DeleteMapping("/{ID}")
    public String deleteProduct(@PathVariable int ID){
        boolean isDelete = productSevice.deleteProduct(ID);
        if (isDelete){
            return "xoa thanh cong san pham: "+ID;
        }else {
            return "khong tim thay san pham de xoa";
        }
    }
}
