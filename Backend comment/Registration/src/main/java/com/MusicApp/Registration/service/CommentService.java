package com.MusicApp.Registration.service;

import java.util.Collection;
import java.util.List;

import com.MusicApp.Registration.model.User;

public interface CommentService<save> {

	public void createUser(List<User> com);

	void deleteAll();

	// User createUser(User comment);

	Collection<User> getAllComments();

	public void deleteAllComments();

	public void deleteUserById(int id);

	public void addUser(User com);

	// void updateUser(int id);

	public User updateUser(User com);

	// public User updateUser(int id);

}
