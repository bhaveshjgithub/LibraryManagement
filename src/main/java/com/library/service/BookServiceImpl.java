package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.exception.ErrorCode;
import com.library.exception.ResourceNotFoundException;
import com.library.repo.BookRepository;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getall() {
	// TODO Auto-generated method stub
	return (List<Book>) bookRepository.findAll();
	}
	@Override
	public void create(Book book) {
		bookRepository.save(book);
		
	}
	@Override
	public void update(Long id, Book book) {
		Optional<Book> bookDta = bookRepository.findById(id);
			if(bookDta.isPresent()){
				Book book2 = bookDta.get();
				book2.setName(book.getName());
				book2.setAuthor(book.getAuthor());
				book2.setYear(book.getYear());
				bookRepository.save(book2);
			}else {
				throw new ResourceNotFoundException(ErrorCode.INVALID_ID.getCode(), ErrorCode.INVALID_ID.getMessage());
				
			}
	}
	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
				
	}

	/*
	 * @Override public Book getBookData(Long id) {
	 * 
	 * return bookRepository.getBookAndUser(id); }
	 */
	@Override
	public Optional<Book> getId(Long id) {
		return bookRepository.findById(id);
		
	}
	@Override
	public Book getBookData(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
