package com.bookapp.Registration.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.Registration.Exception.LoginException;
import com.bookapp.Registration.Exception.RegistrationException;
import com.bookapp.Registration.model.User;
import com.bookapp.Registration.service.RegistrationService;




@CrossOrigin
@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping(value = "/getall")
	public Collection<User> getAll() {
		return registrationService.getAllUsers();
	}
	
	@PostMapping(value = "/registeruser")
	public User  registeruser(@RequestBody User user)   {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj =registrationService.fetchUserByEmailId(tempEmailId);
			if(userobj != null) { 
				throw new RegistrationException("user with this EmailId already exist");
			//throw new Exception("user with"+tempEmailId +"is already exist");
			}
		}
		User userobj = null;
		userobj=registrationService.saveUser(user);
		return userobj ;
	}
	
	
	  @PostMapping(value = "/login")
	  public User loginUser(@RequestBody User user) { 
	  String tempEmailId = user.getEmailId(); 
	  String tempPass = user.getPassword(); 
	  User userobj = null; 
	  if(tempEmailId != null && tempPass!= null) {
	  userobj=registrationService.fetchUserByEmailIdAndPassword(tempEmailId,tempPass); 
	  } 
	  if(userobj == null) 
	  { 
		  throw new LoginException("BadCredential/UserDosenot Exist");
		  //throw new Exception("BadCredential/UserDosenot Exist"); 
	  } 
	  return userobj; 
 }
	 
}
