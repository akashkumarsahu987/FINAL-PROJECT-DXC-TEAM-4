package com.admin.Registration.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.Registration.model.Admin;

public interface Registrationdao extends MongoRepository<Admin, String> {

	public Admin findByEmailId(String emailId);

	public Admin findByEmailIdAndPassword(String emailId, String password);

}
