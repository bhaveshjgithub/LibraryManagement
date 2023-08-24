package com.library.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.LibraryCard;
import com.library.service.LibraryCardService;

@RestController
@RequestMapping("/lib/lcard")
public class LibearyCardController {
	@Autowired
	private LibraryCardService cardService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<LibraryCard>> getAllCards(){
		return new ResponseEntity<List<LibraryCard>>( cardService.getall(),HttpStatus.OK);
		
	}
	@PostMapping("/create-card")
	public ResponseEntity<Void>createCard(@RequestBody LibraryCard card) {
		cardService.create(card);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping("/update-card/{id}")
	public ResponseEntity<Void> updateCard(@PathVariable("id")Long id,@RequestBody LibraryCard card) {
		cardService.update(id, card);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete-card/{id}")  
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
	    cardService.delete(id);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
