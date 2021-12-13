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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.userinfoservice.bean.User;
import com.wipro.userinfoservice.exception.UserRecordNotFoundException;
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
		if(users == null) {
			throw new UserRecordNotFoundException("No User Records available: ");
			
		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PutMapping("/replace")
	public ResponseEntity<User> replaceUser(@RequestBody User userToCreate){
		User user = service.replaceUser(userToCreate);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public User findUserById(@PathVariable int id){
		return service.getUsersById(id).orElseThrow(() -> new UserRecordNotFoundException("User record not found for id : " + id));
	}
	
	@GetMapping("/userid/{userid}")
	public ResponseEntity<List<User>> findByUserByUserId(@PathVariable Integer userid){
		List<User> users = service.findUsersByUserId(userid);
		if(users == null) {
			throw new UserRecordNotFoundException("User record not found for userid : " + userid);
		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<User>> findUserByTitle(@PathVariable String title){
		List<User> users = service.findUsersByTitle(title);
		if(users == null) {
			throw new UserRecordNotFoundException("User record not found for title : " + title);
		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/body/{body}")
	public ResponseEntity<List<User>> findUserByBody(@PathVariable String body){
		List<User> users = service.findUsersByBody(body);
		if(users == null) {
			throw new UserRecordNotFoundException("User record not found for @PathVariable String body : " +body);
		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("distinctusers")
	public List<Integer> getDistinctUserIds(){
		List<Integer> userids = new ArrayList<Integer>();
		userids = service.findDistinctUserId();
		if(userids == null) {
			throw new UserRecordNotFoundException("No  distinct User record found : " );
		}
		return userids;
	}
	
	@PostMapping("/saveUser/{index}")
	public ResponseEntity<User> saveUserAtAnyIndex(@PathVariable Integer index,@RequestBody User user) {
		User savedUser = service.saveUserAtAnyIndex(index,user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		
	}
		
}
