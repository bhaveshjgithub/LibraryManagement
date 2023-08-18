package com.library.repo;

import org.springframework.data.repository.CrudRepository;

import com.library.entity.LibraryCard;

public interface LibraryRepository extends CrudRepository<LibraryCard, Long> {

}
