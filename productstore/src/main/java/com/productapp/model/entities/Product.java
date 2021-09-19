package com.productapp.model.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "product_table")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Double productDiscount;
    private String productCategory;
    private LocalDate expiryDate;
    private Integer productQuantity;
    public Product() {
    	
    }
	public Product(Integer productId, String productName, Double productPrice, Double productDiscount,
			String productCategory, LocalDate expiryDate, Integer productQuantity) {
	
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCategory = productCategory;
		this.expiryDate = expiryDate;
		this.productQuantity = productQuantity;
	}
	public Product( String productName, Double productPrice, Double productDiscount,
			String productCategory, LocalDate expiryDate, Integer productQuantity) {
	
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCategory = productCategory;
		this.expiryDate = expiryDate;
		this.productQuantity = productQuantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
   
}