package com.productapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.dao.Product;
import com.productapp.model.dao.ProductDao;

@Service
@Transactional
public class ProductServiceImp1 implements ProductService{
private ProductDao productdao;
@Autowired
	public ProductServiceImp1(ProductDao productdao) {

	this.productdao = productdao;
}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productdao.getAllProducts();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productdao.addProduct(product);
	}

	@Override
	public void deleteProduct(long product) {
	
		productdao.deleteProduct(product);
	}

	@Override
	public void updateProduct(long id, Product product) {
		productdao.updateProduct(id, product);
		
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return productdao.getProductById(id);
	}


}
