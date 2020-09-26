package com.bookapp.Registration.service;

import java.util.Collection;

import com.bookapp.Registration.model.User;

public interface RegistrationService {

	User saveUser(User user);
	User fetchUserByEmailId(String email);
	User fetchUserByEmailIdAndPassword(String email, String password);
	public Collection<User> getAllUsers();
}
