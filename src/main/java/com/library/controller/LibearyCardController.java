package com.library.controller;

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

import com.library.entity.LibraryCard;
import com.library.service.LibraryCardService;

@RestController
@RequestMapping("/lib/lcard")
public class LibearyCardController {
	@Autowired
	private LibraryCardService cardService;
	
	@GetMapping("/getall")
	public List<LibraryCard> getAllCards(){
		return cardService.getall();
		
	}
	@PostMapping("/create-card")
	public void createCard(@RequestBody LibraryCard card) {
		cardService.create(card);
	}
	@PutMapping("/update-card/{id}")
	public void updateCard(@PathVariable("id")Long id,@RequestBody LibraryCard card) {
		cardService.update(id, card);
	}
	
	@DeleteMapping("/delete-card/{id}")  
	public void deleteBook(@PathVariable("id") Long id) {
	    cardService.delete(id);
	}
	
}
