package com.productapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dao.Product;
import com.productapp.model.service.ProductService;
@RestController
public class ProductController {

	private ProductService productService;
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	//-------------all products-----
	@GetMapping(path = "product")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	//------get an specificn product-
	@GetMapping(path="product/{id}")
	public Product getAnbook(@PathVariable("id")int id) {
		return productService.getProductById(id);
	}
	
	//------add a new product----
	@PostMapping(path="product")
	public Product addbook(@RequestBody Product product ) {
		return productService.addProduct(product);
		
	}
	
//	/--------delete a product-------
	
	@DeleteMapping(path="product/{id}")
	public  void deleteAnProducty(@PathVariable(name="id")int id) {
		 productService.deleteProduct(id);
	}
	
	
	//----update the product-
	@PostMapping(path = "product/{id}")
	public void updateBook(@PathVariable(name="id")int id,@RequestBody Product product) {
		 productService.updateProduct(id, product);
	}
}
