package com.bookapp;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.repo.Book;
import com.bookapp.model.service.BookService;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner{
	@Autowired
	private BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//	bookService.addBook(new Book("rich dada poor dad",400.00));	
//	bookService.addBook(new Book("monk who sold the ferrari",200.00));
	
	//System.out.println("books are added");
	}

}
