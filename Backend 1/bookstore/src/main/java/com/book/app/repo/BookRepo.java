package com.book.app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book.app.model.Book;

@Repository
public interface BookRepo extends MongoRepository<Book, Integer> {

	List<Book> findByTitle(String title);
}