package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.dao.Product;
import com.productapp.model.service.ProductService;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner{
	@Autowired
	private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		productService.addProduct(new Product("Tv",1000.00,400.00,"electronics", 1L));
		productService.addProduct(new Product("earphones",100.00,40.00,"electronics", 1L));
//	bookService.addBook(new Book("rich dada poor dad",400.00));	
//	bookService.addBook(new Book("monk who sold the ferrari",200.00));
	
	System.out.println("products are added");
	}

}
