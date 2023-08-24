package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.library.entity.Book;



public interface BookService {

	List<Book> getall();
	
	Optional<Book> getId(Long id);
	
	void create(Book book);
	
	void update(Long id, Book book);
	
	void delete(Long id);

	Book getBookData(Long id);

	

	
}
