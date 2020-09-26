package com.book.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.app.exceptions.EmployeeException;
import com.book.app.model.Book;
import com.book.app.repo.BookRepo;

@Service
public class BookServiceimpl implements BookService {

	@Autowired
	BookRepo bookRepo;

		@Override
	public void createBook(List<Book> emp) {
		bookRepo.saveAll(emp);
	}

	@Override
	public Collection<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Optional<Book> findBookById(int id) {
		return bookRepo.findById(id);
	}

	@Override
	public void deleteBookById(int id) {
		bookRepo.deleteById(id);
	}

	@Override
	public Book updateBook(Book emp) {
		return bookRepo.save(emp);
	}

	@Override
	public void deleteAllBooks() {
		bookRepo.deleteAll();
	}

	@Override
	public List<Book> getBookByTitle(String name) {
		// TODO Auto-generated method stub
		
		return bookRepo.findByTitle(name);
	}

	@Override
	public void addBook(Book emp) {
		// TODO Auto-generated method stub
		if(bookRepo.findById(emp.getId()).isPresent())
		{
			throw new EmployeeException("Id already exists");
		}
		else
		bookRepo.save(emp);
		
	}
}