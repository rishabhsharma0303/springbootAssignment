package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.dao.Book;

public interface BookService {
	public List<Book> getAllbooks();
	public Book addBook(Book book);
	public Book updateBook(int id,Book book);

	public Book getBookById(int id);
	public Book DeleteBook(int id);
}
