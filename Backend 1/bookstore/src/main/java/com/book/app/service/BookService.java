package com.book.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.book.app.model.Book;

public interface BookService {

	public void createBook(List<Book> book);

	public Collection<Book> getAllBooks();

	public Optional<Book> findBookById(int id);

	public void deleteBookById(int id);

	public Book updateBook(Book emp);

	public void deleteAllBooks();

	public List<Book> getBookByTitle(String title);

	public void addBook(Book book);
}