package com.bookapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book> > getAllBooks()
	{
		return ResponseEntity.ok(bookService.getAllbooks());
	}
	
	//------get an specificn book-
	@GetMapping(path="book/{id}")
	public ResponseEntity<Book> getAnbook(@PathVariable("id")int id) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
	}
	
	//------add a new book----
	@PostMapping(path="book")
	public ResponseEntity<Book> addbook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
	
		
	}
	
//	/--------delete a book-------
	
	@DeleteMapping(path="book/{id}")
	public  ResponseEntity<String> deleteAnbook(@PathVariable(name="id")int id) {
		 bookService.DeleteBook(id);
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body("book is delted");
	}
	
	
	//----update the book-
	@PostMapping(path = "book/{id}")
	public ResponseEntity<Book>  updateBook(@PathVariable(name="id")int id,@RequestBody Book book) {
		return ResponseEntity.ok(bookService.updateBook(id, book));
	}
}
