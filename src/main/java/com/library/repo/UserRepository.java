package com.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
