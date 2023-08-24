package com.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	
	
	
	
	/*
	 * @Query(
	 * value="SELECT book_details.name, book_details.author, user_table.name AS userName, user_table.Address"
	 * + "FROM book_details" +
	 * "INNER JOIN user_table ON user_table.id = book_details.user_id" +
	 * "WHERE book_details.id = ?;",nativeQuery = true)
	 */

	  //Book getBookAndUser(Long id);
	 
}
