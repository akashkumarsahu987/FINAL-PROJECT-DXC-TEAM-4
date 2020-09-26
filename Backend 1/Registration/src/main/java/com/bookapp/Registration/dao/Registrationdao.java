package com.bookapp.Registration.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookapp.Registration.model.User;



public interface Registrationdao extends MongoRepository<User, String>  {

	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);

}
