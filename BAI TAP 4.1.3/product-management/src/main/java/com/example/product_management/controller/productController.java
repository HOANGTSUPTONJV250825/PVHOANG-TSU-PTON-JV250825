package com.example.product_management.controller;

import com.example.product_management.sevice.productSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {
    @Autowired
    private productSevice productSevice;
}
