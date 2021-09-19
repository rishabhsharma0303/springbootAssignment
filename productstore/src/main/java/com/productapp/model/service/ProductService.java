package com.productapp.model.service;

import java.util.List;

import com.productapp.model.entities.Product;

public interface ProductService {
    public List<Product> findAll();
    public Product getProductById(int id);
    public Product addProduct(Product product);
    public Product updateProduct(int productId, Product product);
    public Product deleteProduct(int productId);
    public List<Product> findByProductCategory(String productCategory);
}