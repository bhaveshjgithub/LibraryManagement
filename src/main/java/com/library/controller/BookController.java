package com.library.controller;

import java.security.Policy;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.entity.LibraryCard;
import com.library.service.BookService;
import com.library.service.LibraryCardService;

@RestController
@RequestMapping("/lib/book")
public class BookController {

	@Autowired
	private BookService bookService; // 
	
	@GetMapping("/getall")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.getall(),HttpStatus.OK);
		
	}
	@PostMapping("/create-book")
	public ResponseEntity<Void>createBook(@RequestBody Book book) {
		bookService.create(book);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping("/update-book/{id}")
	public ResponseEntity<Void> updateBook(@PathVariable("id") Long id,@RequestBody Book book) {
	bookService.update(id, book);
	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping("/delete-book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
	    bookService.delete(id);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	    
	}
	@GetMapping("/getid")
	public ResponseEntity<Book> getdata(@RequestParam Long id) {
		return new ResponseEntity<Book> (bookService.getBookData(id),HttpStatus.OK);
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Optional<Book>> getDataId(@PathVariable("id") Long id) {
		return new ResponseEntity<Optional<Book>>(bookService.getId(id),HttpStatus.OK);
		
	}
	
}
