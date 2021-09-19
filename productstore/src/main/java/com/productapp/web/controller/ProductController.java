package com.productapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.Product;
import com.productapp.model.service.ProductService;

@RestController
public class ProductController {
 
    private ProductService productService;
 
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
 
    // -------------------getAll product--------
    @GetMapping(path = "product")
    public List<Product> getAll() {
        return productService.findAll();
    }
 
    // -------------------get an product--------
    @GetMapping(path = "product/{id}")
    public Product getAnProduct(@PathVariable(name = "id") int id) {
        return productService.getProductById(id);
    }
 
    // ---------------delete------------
    @DeleteMapping(path = "product/{id}")
    public Product deleteAnProduct(@PathVariable(name = "id") int id) {
        return productService.deleteProduct(id);
    }
 
    // ---------------update------------
    @PutMapping(path = "product/{id}")
    public Product updateAnProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
 
    //-----------add new product----------
    @PostMapping(path = "product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
