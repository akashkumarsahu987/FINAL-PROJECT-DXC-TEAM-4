package com.MusicApp.Registration.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MusicApp.Registration.model.User;

public interface CommentDao extends MongoRepository<User, String> {

	public User findByEmailId(String emailId);

	public void deleteById(int id);

	public Optional<User> findById(int id);

	// public User updateById(int id);

}
