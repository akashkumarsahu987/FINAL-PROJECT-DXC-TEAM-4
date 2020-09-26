package com.admin.Registration.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.Registration.Exception.LoginException;
import com.admin.Registration.Exception.RegistrationException;
import com.admin.Registration.model.Admin;
import com.admin.Registration.service.RegistrationService;

@CrossOrigin
@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	/*
	 * @PostMapping(value = "/registeradmin") public Admin registeruser(@RequestBody
	 * Admin admin) { String tempEmailId = admin.getEmailId(); String
	 * tempsCode=admin.getsCode(); String pass="admin123"; if(tempEmailId != null &&
	 * !"".equals(tempEmailId) && tempsCode!=null && !"".equals(pass)) { Admin
	 * userobj =registrationService.fetchUserByEmailId(tempEmailId); if(userobj !=
	 * null && !tempsCode.equals(pass)) { throw new
	 * RegistrationException("user with this EmailId already exist"); //throw new
	 * Exception("user with"+tempEmailId +"is already exist"); } }
	 * 
	 * return registrationService.saveAdmin(admin);
	 * 
	 * }
	 */

	@PostMapping(value = "/login")
	public Admin loginUser(@RequestBody Admin admin) {
		String tempEmailId = admin.getEmailId();
		String tempPass = admin.getPassword();
		String tempsCode = admin.getsCode();
		Admin adminobj = null;
		if (tempEmailId != null && tempPass != null && tempsCode != null) {
			adminobj = registrationService.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if (adminobj == null) {
			throw new LoginException("BadCredential/UserDosenot Exist");

		}
		return adminobj;
	}

}
