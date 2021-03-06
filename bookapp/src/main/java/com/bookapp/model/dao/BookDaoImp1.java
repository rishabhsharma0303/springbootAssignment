package com.bookapp.model.dao;

import java.util.List;
import com.bookapp.model.dao.BookNotFoundException;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BookDaoImp1 implements BookDao{

	private EntityManager em;
	@Autowired
	  public BookDaoImp1( EntityManager em) {
		this.em=em;
	}
	
	@Override
	public List<Book> getAllbooks() {
		// TODO Auto-generated method stub
		return em.createQuery("select b from Book b",Book.class ).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book updateBook(int id,Book book) {
	Book bookToUpdate=getBookById(id);
	bookToUpdate.setPrice(book.getPrice());
	em.merge(book);
		return book;
	}

	@Override
	public Book getBookById(int id) {
		Book book=em.find(Book.class, id);
		if(book==null) {
			throw new BookNotFoundException("Book with "+id+"not found");
		}
		return book;
	}

	@Override
	public Book DeleteBook(int id) {
	Book book=getBookById(id);
	em.remove(book);
		return book;
	}

}
