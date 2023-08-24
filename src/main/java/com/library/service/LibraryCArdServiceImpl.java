package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.LibraryCard;
import com.library.entity.User;
import com.library.exception.ErrorCode;
import com.library.exception.ResourceNotFoundException;
import com.library.repo.BookRepository;
import com.library.repo.LibraryRepository;
@Service
public class LibraryCArdServiceImpl implements LibraryCardService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public List<LibraryCard> getall() {
		// TODO Auto-generated method stub
		return (List<LibraryCard>) libraryRepository.findAll();
	}

	@Override
	public void create(LibraryCard card) {
		// TODO Auto-generated method stub
		libraryRepository.save(card);
	}

	@Override
	public void update(Long id, LibraryCard card) {
		// TODO Auto-generated method stub
		Optional<LibraryCard> libData = libraryRepository.findById(id);
		if(libData.isPresent()) {
			LibraryCard card2 = libData.get();
			card2.setBookDetails(card.getBookDetails());
			libraryRepository.save(card2);	
		}else {
			throw new ResourceNotFoundException(ErrorCode.DATA_NOT_FOUND.getCode(), ErrorCode.DATA_NOT_FOUND.getMessage());
			
		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libraryRepository.deleteById(id);
	}
	
	
	
}
