package com.admin.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.Registration.dao.Registrationdao;
import com.admin.Registration.model.Admin;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	Registrationdao registrationDao;

	@Override
	public Admin saveAdmin(Admin admin) {

		return registrationDao.save(admin);
	}

	@Override
	public Admin fetchUserByEmailId(String email) {
		return registrationDao.findByEmailId(email);

	}

	@Override
	public Admin fetchUserByEmailIdAndPassword(String email, String password) {

		return registrationDao.findByEmailIdAndPassword(email, password);

	}

}
