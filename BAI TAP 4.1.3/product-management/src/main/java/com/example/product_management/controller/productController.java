package com.example.product_management.controller;

import com.example.product_management.model.products;
import com.example.product_management.sevice.productSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
