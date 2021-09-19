package com.productapp;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.productapp.model.entities.Product;
import com.productapp.model.service.ProductService;

@Component
public class DataInit implements CommandLineRunner {
 
    @Autowired
    private ProductService proudctService;
 
    @Override
    public void run(String... args) throws Exception {
        // productName, productPrice, productDiscount, productCategory, expiryDate,
        // productQuantity
    
        proudctService.addProduct( new Product("dell laptop", 55000.0, 5000.0, "Electronic", LocalDate.of(2028, Month.APRIL, 22), 40));
        proudctService.addProduct(
                new Product("maths register", 55.0, 1.0, "Stationary", LocalDate.of(2023, Month.APRIL, 22), 4000));

    }
 
}
