package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookapp.model.repo.Book;
import com.bookapp.model.service.BookService;
@Controller
public class BookController {
	private BookService bookService;
	@Autowired
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	//-------------all books-----

	@GetMapping(value = "allbooks")
	public String showAllBook(ModelMap map) {
		map.addAttribute("books", bookService.getAllbooks());
		return "allbooks";
	}
	@GetMapping(value = "addbook")
	public String addBookGet(ModelMap map) {
		map.addAttribute("book", new Book());
		return "bookform";
	}
	
	@GetMapping(value = "deletebook")
	public String deleteBook(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		bookService.DeleteBook(id);

		return "redirect:allbooks";
	}

	@GetMapping(value = "updatebook")
	public String updateBook(HttpServletRequest request, ModelMap map) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Book book = bookService.getBookById(id);
		map.addAttribute("book", book);

		return "editbookform";
	}
	@PostMapping(value = "addbook")
	public String addBookPost(@ModelAttribute(name = "book") Book book) {
		
		Integer id = book.getId();
		if (id == 0) {
			bookService.addBook(book);
		}else {
			bookService.updateBook(id, book);
		}
		return "redirect:allbooks";
	}
}
