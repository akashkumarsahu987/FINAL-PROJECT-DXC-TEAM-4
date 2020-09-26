package com.MusicApp.Registration.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicApp.Registration.Exception.CommentException;
import com.MusicApp.Registration.dao.CommentDao;
import com.MusicApp.Registration.model.User;

@Service
public class CommentServiceimpl implements CommentService {
	@Autowired
	CommentDao commentDao;

	@Override
	public void createUser(List<User> com) {

		commentDao.saveAll(com);
	}

	@Override
	public Collection getAllComments() {
		// TODO Auto-generated method stub
		return commentDao.findAll();
	}

	@Override
	public User updateUser(User com) {
		return commentDao.save(com);
	}

	@Override
	public void deleteUserById(int id) {
		commentDao.deleteById(id);
	}

	@Override
	public void deleteAllComments() {
		commentDao.deleteAll();

	}

	@Override
	public void addUser(User com) {
		// TODO Auto-generated method stub
		if (commentDao.findById(com.getId()).isPresent()) {
			throw new CommentException("Id already exists");
		} else
			commentDao.save(com);

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
