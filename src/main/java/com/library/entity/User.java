 package com.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private String Address;
	@OneToOne(cascade = CascadeType.ALL)
	private Book book;
	@OneToOne(cascade = CascadeType.ALL)
	private LibraryCard card;
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LibraryCard getCard() {
		return card;
	}
	public void setCard(LibraryCard card) {
		this.card = card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book1) {
		this.book = book1;
	}
}