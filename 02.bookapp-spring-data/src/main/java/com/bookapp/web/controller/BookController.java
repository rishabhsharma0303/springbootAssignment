package com.bookapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.repo.Book;
//@RestController=@Controller +@ResponseBody(it coovert java obj-->json automatically by trigeering a parser
import com.bookapp.model.service.BookService;
@RestController
public class BookController {

	private BookService bookService;
	@Autowired
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	//-------------all books-----
	@GetMapping(path = "book")
	public List<Book> getAllBooks()
	{
		return bookService.getAllbooks();
	}
	
	//------get an specificn book-
	@GetMapping(path="book/{id}")
	public Book getAnbook(@PathVariable("id")int id) {
		return bookService.getBookById(id);
	}
	
	//------add a new book----
	@PostMapping(path="book")
	public Book addbook(@RequestBody Book book) {
		return bookService.addBook(book);
		
	}
	
//	/--------delete a book-------
	
	@DeleteMapping(path="book/{id}")
	public Book deleteAnbook(@PathVariable(name="id")int id) {
		return bookService.DeleteBook(id);
	}
	
	
	//----update the book-
	@PostMapping(path = "book/{id}")
	public Book updateBook(@PathVariable(name="id")int id,@RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
}
