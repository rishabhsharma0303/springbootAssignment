package com.productapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.dao.Product;
import com.productapp.model.dao.ProductNotFoundException;
import com.productapp.model.dao.ProductRepo;

@Service
@Transactional
public class ProductServiceImp1 implements ProductService{
private ProductRepo productRepo;
@Autowired
	public ProductServiceImp1(ProductRepo productRepo) {

	this.productRepo = productRepo;
}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(long id) {
	
		Product  productToDelete=getProductById(id);
		productRepo.delete(productToDelete);
	}

	@Override
	public void updateProduct(long id, Product product) {
		Product productToBeUpdated=getProductById(id);
		productToBeUpdated.setProductPrice(product.getProductPrice());
		productRepo.save(productToBeUpdated);
		
		
	}

	@Override
	public Product getProductById(long id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product with id : " + id + " not found"));
	}


}
