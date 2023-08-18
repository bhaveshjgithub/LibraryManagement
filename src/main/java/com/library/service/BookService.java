package com.library.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.library.entity.Book;



public interface BookService {

	List<Book> getall();
	
	void create(Book book);
	
	void update(Long id, Book book);
	
	void delete(Long id);
	
}
