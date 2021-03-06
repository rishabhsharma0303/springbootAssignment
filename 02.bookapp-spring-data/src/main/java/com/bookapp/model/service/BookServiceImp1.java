package com.bookapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.repo.Book;
import com.bookapp.model.repo.BookNotFoundException;
import com.bookapp.model.repo.BookRepo;

@Service
@Transactional
public class BookServiceImp1 implements BookService{

	private BookRepo bookRepo;
	@Autowired
	 public BookServiceImp1(BookRepo bookRepo) {
		this.bookRepo=bookRepo;
	}
	@Override
	public List<Book> getAllbooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate=getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		bookRepo.save(bookToUpdate);
		return bookToUpdate;
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).orElseThrow(()->new BookNotFoundException("book with "+id+"not found"));
	}

	@Override
	public Book DeleteBook(int id) {
		Book  bookToDelete=getBookById(id);
		bookRepo.delete(bookToDelete);
		return bookToDelete;
	}

}
