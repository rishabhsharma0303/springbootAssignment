package com.productapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDaoImpl implements ProductDao {
	private EntityManager em;
	
	@Autowired
	public ProductDaoImpl(EntityManager em) {
	
		this.em = em;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return em.createQuery("select b from Product b",Product.class ).getResultList();
	}

	@Override
	public Product addProduct(Product product) {
		em.persist(product);
		return product;
	
	}

	@Override
	public void deleteProduct(long product) {
		Product produt=getProductById(product);
		em.remove(produt);
		
		
	}

	@Override
	public void updateProduct(long id, Product product) {
	
		Product productToUpdate=getProductById(id);
		productToUpdate.setProductPrice(product.getProductPrice());
		em.merge(product);
			
	}

	@Override
	public Product getProductById(long id) {
		Product product=em.find(Product.class, id);
		if(product==null) {
			throw new ProductNotFoundException("Book with "+id+"not found");
		}
		return product;
	}

}
