package com.au.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.library.dao.BooksDAO;
import com.au.library.model.Book;

@RestController
public class BooksController {
	@Autowired
	BooksDAO bookDao;
	
	@RequestMapping(value="/getbooks", method=RequestMethod.GET, produces = "application/json")
	public List<Book> getAll() {
		
		/*
		 * List<Book> books = new ArrayList<>(); books.add(new Book("1","Marvel Comics",
		 * "Stanlee", 200D, "Awesome book")); books.add(new Book("2","Friends", "YYY",
		 * 200D, "Awesome book")); books.add(new Book("3", "DC", "XXX", 200D,
		 * "Good book"));
		 * 
		 * return books;
		 */
		List<Book> books = new ArrayList<>();
		books = bookDao.getAllFromDB();
		
		return books;
	}
	
	@RequestMapping(value="/getbook", method=RequestMethod.GET, produces = "application/json")
	public Book getBook() {
		//List<Book> books = new ArrayList<>();
		return new Book("1", "Marvel Comics", "Stanlee", 200D, "Awesome book");
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.POST)
	public Book insertBook(@RequestBody Book book) {
		return bookDao.addBook(book);
	}
	
	@RequestMapping(value="/addcart", method=RequestMethod.POST)
	public Book insertBookCart(@RequestBody Book book) {
		return bookDao.addBookCart(book);
	}
	
	@RequestMapping(value="/getcart", method=RequestMethod.GET, produces = "application/json")
	public List<Book> getCartBooks() {
		List<Book> books = new ArrayList<>();
		books = bookDao.getCartBooks();
		
		return books;
	}
	
	@RequestMapping(value="/deletecart", method=RequestMethod.POST)
	public void deleteCartBook(@RequestBody Book book) {
		System.out.println(book);
		bookDao.deleteCartBook(book);
	}
	
	
}
