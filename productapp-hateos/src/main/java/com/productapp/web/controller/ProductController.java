package com.productapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.productapp.model.dao.Product;
import com.productapp.model.service.ProductService;
import javax.validation.Valid;
@RestController
public class ProductController {

	private ProductService productService;
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	//-------------all products-----
	@GetMapping(path = "product")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}
	
	@GetMapping("/product/v2")
	public CollectionModel<Product> getAllProductsV2() {

		List<Product> allProducts = productService.getAllProducts();

		allProducts.forEach(product -> {
			Link link = linkTo(methodOn(ProductController.class).getAllProductsV2()).withSelfRel();
			product.add(link);
		});

		return CollectionModel.of(allProducts);
	}
	
	//------get an specificn product-
	@GetMapping(path="product/{id}")
	public ResponseEntity<Product> getAnProduct(@PathVariable("id")int id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
	}
	

	@GetMapping("/product/v2/{id}")
	public EntityModel<Product> getProductByIdV2(@PathVariable(name = "id") long id) {
		Link link = linkTo(methodOn(ProductController.class).getProductByIdV2(id)).withSelfRel();
		Product product = productService.getProductById(id);
		product.add(link);
		return EntityModel.of(product);
	}
	
	//------add a new product----
	@PostMapping(path="product")
	public ResponseEntity<Product>  addProduct(@Valid @RequestBody Product product ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
		
	}
	
//	/--------delete a product-------
	
	@DeleteMapping(path="product/{id}")
	public  ResponseEntity<String> deleteAnProduct(@PathVariable(name="id")long id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("product with id :"+id+" deleted successfully");
	}
	
	
	//----update the product-
	@PutMapping(path = "product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(name="id")long id,@RequestBody Product product) {
	return 	ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
	}
}
