package com.library.service;

import java.util.List;

import com.library.entity.LibraryCard;


public interface LibraryCardService {

List<LibraryCard> getall();
	
	void create(LibraryCard card);
	
	void update(Long id, LibraryCard card);
	
	void delete(Long id);
	
	
}
