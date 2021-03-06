package com.bookapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;

@Service
@Transactional
public class BookServiceImp1 implements BookService{

	private BookDao bookDao;
	@Autowired
	 public BookServiceImp1(BookDao bookDao) {
		this.bookDao=bookDao;
	}
	@Override
	public List<Book> getAllbooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllbooks();
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public Book updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

	@Override
	public Book DeleteBook(int id) {
		// TODO Auto-generated method stub
		return bookDao.DeleteBook(id);
	}

}
