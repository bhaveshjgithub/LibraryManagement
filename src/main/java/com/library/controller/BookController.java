package com.library.controller;

import java.security.Policy;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.entity.LibraryCard;
import com.library.service.BookService;
import com.library.service.LibraryCardService;

@RestController
@RequestMapping("/lib/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/getall")
	public List<Book> getAllBooks(){
		return bookService.getall();
		
	}
	@PostMapping("/create-book")
	public void createBook(@RequestBody Book book) {
		bookService.create(book);
	}
	@PutMapping("/update-book/{id}")
	public void updateBook(@PathVariable("id") Long id,@RequestBody Book book) {
	bookService.update(id, book);
	}
	@DeleteMapping("/delete-book/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
	    bookService.delete(id);
	}
}
