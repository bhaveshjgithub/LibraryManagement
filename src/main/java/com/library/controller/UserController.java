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


import com.library.entity.User;
import com.library.service.UserService;

@RestController
@RequestMapping("/lib/user")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/getall")
	public List<User> getAllUser(){
		return userservice.getall();
		
	}
	@PostMapping("/create-user")
	public void createUser(@RequestBody User user) {
		userservice.create(user);
	}
	@PutMapping("/update-user/{id}")
	public void updateUser(@PathVariable("id") Long id,@RequestBody User user) {
		userservice.update(id, user);
	}
	@DeleteMapping("/delete-user/{id}") 
	public void deleteUser(@PathVariable("id") Long id) {
	    userservice.delete(id);
	}
	
}
