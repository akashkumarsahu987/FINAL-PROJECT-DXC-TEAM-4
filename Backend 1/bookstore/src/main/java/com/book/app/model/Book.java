package com.book.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection = "Book")
public class Book {

	@Id
	private int id;
	private String title;
	private String author;
	private String category;
	private String description;
	private int isbn;
	private String language;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Book(int id, String title, String author,String category, String description, int isbn, String language) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.language = language;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	}