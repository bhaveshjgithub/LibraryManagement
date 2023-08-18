package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public void update(Long id, User user) {
		
		Optional<User> userData = userRepository.findById(id);
		if(userData.isPresent()) {
			User user2 =userData.get();
			user2.setName(user.getName());
			user2.setAddress(user.getAddress());
			userRepository.save(user2);
		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
