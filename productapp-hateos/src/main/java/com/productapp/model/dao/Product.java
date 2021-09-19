package com.productapp.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_table")
public class Product extends RepresentationModel<Product> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long  productId;
private String productName;
private Double productPrice;
private Double productDiscount;
private String productCategory;
private Long productQuantity;
public Product(String productName, Double productPrice, Double productDiscount, String productCategory,
		Long productQuantity) {

	this.productName = productName;
	this.productPrice = productPrice;
	this.productDiscount = productDiscount;
	this.productCategory = productCategory;
	this.productQuantity = productQuantity;
}



//getter setter , ctr
}