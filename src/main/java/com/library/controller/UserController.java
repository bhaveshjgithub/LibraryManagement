package com.library.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.service.UserService;

@RestController
@RequestMapping("/lib/user")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(userservice.getall(), HttpStatus.OK);
		
	}
	@PostMapping("/create-user")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		userservice.create(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping("/update-user/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable("id") Long id,@RequestBody User user) {
		userservice.update(id, user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@DeleteMapping("/delete-user/{id}") 
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
	    userservice.delete(id);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/{uid}/book/{bid}")
    public void getUserGetsBook(@PathVariable("uid") Long uid, @PathVariable("bid") Long bid) {
		userservice.userGetsBook(uid, bid);
	}
	@GetMapping("/userbyid/{id}")
	public Optional<User> getUserByid(@PathVariable("id") Long id) {
		return userservice.getById(id);
	}
	
}
