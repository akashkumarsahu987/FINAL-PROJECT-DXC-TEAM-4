package com.MusicApp.Registration.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MusicApp.Registration.model.User;
import com.MusicApp.Registration.service.CommentService;

@CrossOrigin
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	@GetMapping(value = "/getall")
	public Collection<User> getAll() {

		return commentService.getAllComments();
	}

	@PostMapping(value = "/createcomment")
	public String create(@RequestBody List<User> com) {

		commentService.createUser(com);
		return "Comments are created.";
	}

	@PostMapping(value = "/addcomment")
	public ResponseEntity<String> addEmp(@RequestBody User com) {

		commentService.addUser(com);
		return new ResponseEntity<String>("Comment added succesfull.", HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") int id, @RequestBody User com) {
		com.setId(id);
		commentService.updateUser(com);
		return "Your comment is updated succesfully";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		commentService.deleteAllComments();
		return "Your comment is deleted succesfully";
	}

	@DeleteMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") int id) {
		commentService.deleteUserById(id);
		return "Comment is deleted";
	}

}
