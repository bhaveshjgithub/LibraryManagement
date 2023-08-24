package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.User;

public interface UserService {

	List<User> getall();
	
	void create(User user);
	
	void update(Long id, User user);
	
	void delete(Long id);
	
	void userGetsBook(Long uid, Long bid);
	
	Optional<User> getById(Long id);
	
}
