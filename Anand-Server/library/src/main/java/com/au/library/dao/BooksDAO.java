package com.au.library.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.au.library.model.Book;

@Repository
public class BooksDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Book> getAllFromDB() {
		return jdbcTemplate.query("select * from booktable", (rs,i) -> {
			return new Book(rs.getString("bookId"),rs.getString("bookName"),rs.getString("authorName"),rs.getDouble("Price"),rs.getString("descr"));
		});
	}
	
	public Book addBook(Book book) {
		String query = "insert into booktable values ('"+book.getId()+"','"+book.getBookName()+"','"+book.getAuthorName()+"',"+book.getPrice()+",'"+book.getDescription()+"')";
		jdbcTemplate.update(query);
		return book;
	}
	
	public Book addBookCart(Book book) {
		String query = "insert into bookcarttable values ('"+book.getId()+"','"+book.getBookName()+"','"+book.getAuthorName()+"',"+book.getPrice()+",'"+book.getDescription()+"')";
		jdbcTemplate.update(query);
		return book;
	}
	
	public List<Book> getCartBooks() {
		return jdbcTemplate.query("select * from bookcarttable", (rs,i) -> {
			return new Book(rs.getString("bookId"),rs.getString("bookName"),rs.getString("authorName"),rs.getDouble("Price"),rs.getString("descr"));
		});
	}
	
	public void deleteCartBook(Book book) {
		System.out.println(book);
		String query = "delete from bookcarttable where bookId = '"+book.getId()+"'";
		jdbcTemplate.update(query);
	}
}
