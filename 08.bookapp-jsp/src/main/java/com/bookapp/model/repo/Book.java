package com.bookapp.model.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "book_table")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	
private String title;
private Double price;
public Book(String title, Double price) {

	this.title = title;
	this.price = price;
}
	
}
