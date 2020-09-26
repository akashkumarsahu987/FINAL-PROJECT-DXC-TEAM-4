package com.admin.Registration.service;

import com.admin.Registration.model.Admin;

public interface RegistrationService {

	Admin saveAdmin(Admin admin);
	Admin fetchUserByEmailId(String email);
	Admin fetchUserByEmailIdAndPassword(String email, String password);
}
