package com.productapp.model.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepo extends JpaRepository<Product, Long> {

	
}
