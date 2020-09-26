package com.book.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.app.model.Book;
import com.book.app.service.BookService;


//@CrossOrigin(Cross-Origin Resource Sharing annotation is used for access to selected resources 
@CrossOrigin
@RestController
@RequestMapping(value = "/api/mongo/book")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping(value = "/create")
	public String create(@RequestBody List<Book> emp) {

		bookService.createBook(emp);
		return "Book records created.";
	}

	@PostMapping(value = "/add")
	public ResponseEntity<String> addEmp(@RequestBody Book emp) {

		bookService.addBook(emp);
		return new ResponseEntity<String>("New Book record created.", HttpStatus.OK);
	}

	@GetMapping(value = "/demo")
	public String getDemo() {

		return "BOOK WORLD";
	}

	@GetMapping(value = "/getall")
	public Collection<Book> getAll() {

		return bookService.getAllBooks();
	}

	@GetMapping(value = "/getbyTitle/{name}")
	public List<Book> getByName(@PathVariable(value = "name") String name) {

		return bookService.getBookByTitle(name);
	}

	@GetMapping(value = "/getbyid/{book-id}")
	public Optional<Book> getById(@PathVariable(value = "book-id") int id) {

		return bookService.findBookById(id);
	}

	@PutMapping(value = "/update/{book-id}")
	public String update(@PathVariable(value = "book-id") int id, @RequestBody Book e) {
		e.setId(id);
		bookService.updateBook(e);
		return "Book record for book-id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{book-id}")
	public String delete(@PathVariable(value = "book-id") int id) {
		bookService.deleteBookById(id);
		return "Book record for book-id= " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		bookService.deleteAllBooks();
		return "All Book records deleted.";
	}
}