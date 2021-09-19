package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.entities.Product;
import com.productapp.model.repo.ProductRepo;
import com.productapp.model.service.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;

	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product with id " + id + " is not found"));
	}

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product productToUpdate = getProductById(productId);
		productToUpdate.setProductDiscount(product.getProductDiscount());
		productToUpdate.setProductPrice(product.getProductPrice());
		productToUpdate.setProductQuantity(product.getProductQuantity());

		productRepo.save(productToUpdate);

		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		Product productToDelete = getProductById(productId);
		productRepo.delete(productToDelete);
		return productToDelete;
	}

	@Override
	public List<Product> findByProductCategory(String productCategory) {
		return productRepo.findByProductCategory(productCategory);
	}

}
