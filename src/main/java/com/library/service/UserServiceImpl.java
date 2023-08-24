package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.exception.ErrorCode;
import com.library.exception.ResourceNotFoundException;
import com.library.repo.BookRepository;
import com.library.repo.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
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
		}else {
			throw new ResourceNotFoundException(ErrorCode.DATA_NOT_FOUND.getCode(), ErrorCode.DATA_NOT_FOUND.getMessage());
			
		}
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	public void userGetsBook(Long uid, Long bid) {
		Optional<User> userData1 = userRepository.findById(uid);
        Optional<Book> book = bookRepository.findById(bid); 

        if (userData1.isPresent() && book.isPresent()) {
        	User user3 =userData1.get();
        	Book book1 =book.get();
        	user3.setBook(book1);
        	book1.setUser(user3);
            

            userRepository.save(user3);
            bookRepository.save(book1); 
        }
            
        }

	@Override
	public Optional<User> getById(Long id) {
		
		return userRepository.findById(id);
	}

}
