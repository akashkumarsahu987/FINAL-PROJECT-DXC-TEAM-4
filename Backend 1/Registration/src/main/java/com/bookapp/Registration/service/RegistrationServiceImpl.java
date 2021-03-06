package com.bookapp.Registration.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.Registration.dao.Registrationdao;
import com.bookapp.Registration.model.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	Registrationdao registrationDao;

	@Override
	public User saveUser(User user) {
		
		return registrationDao.save(user);
	}

	@Override
	public User fetchUserByEmailId(String email) {
		return registrationDao.findByEmailId(email);
		
	}

	
	  @Override
	  public User fetchUserByEmailIdAndPassword(String email, String password) {
	  
	  return registrationDao.findByEmailIdAndPassword(email, password);
			  
	  }
	  @Override
	public Collection<User> getAllUsers() {
		return registrationDao.findAll();
	}
	 

}
