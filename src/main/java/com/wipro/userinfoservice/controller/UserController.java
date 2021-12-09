package com.wipro.userinfoservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.userinfoservice.bean.User;
import com.wipro.userinfoservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = new ArrayList<User>();
		users = service.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<User>> findUserById(@PathVariable Integer id){
		Optional<User> users = service.getUsersById(id);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/userid/{userid}")
	public ResponseEntity<List<User>> findByUserByUserId(@PathVariable Integer userid){
		List<User> users = service.findUsersByUserId(userid);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<User>> findUserByTitle(@PathVariable String title){
		List<User> users = service.findUsersByTitle(title);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/body/{body}")
	public ResponseEntity<List<User>> findUserByBody(@PathVariable String body){
		List<User> users = service.findUsersByBody(body);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("distinct/userids")
	public List<Integer> getDistinctUserIds(){
		List<Integer> userids = new ArrayList<Integer>();
		userids = service.findDistinctUserId();
		return userids;
	}
	
	@PostMapping("/saveFourth")
	public ResponseEntity<User> saveFourthUser(@RequestBody User fourthUser) {
		User savedUser = service.saveFourthUser(fourthUser);
		return new ResponseEntity<>(savedUser,HttpStatus.OK);
		
	}
}
