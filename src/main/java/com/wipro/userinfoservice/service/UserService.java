package com.wipro.userinfoservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.userinfoservice.bean.User;
import com.wipro.userinfoservice.repository.UserRespository;


@Service
public class UserService {
	
	Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired 
	private UserRespository repository;
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User replaceUser(User newUser) {
		return repository.findById(newUser.getId())
			      .map(user -> {
			    	  System.out.println(user);
			    	  user.setBody(newUser.getBody());
			    	  user.setTitle(newUser.getTitle());
			        return repository.save(user);
			      }).orElseGet(() -> 
			      		{ return repository.save(newUser);});
	}
	
	public Optional<User> getUsersById(Integer id){
		Optional<User> user = null;
		try {
			user = repository.findById(id);
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return user;
		
	}
	
	public List<User> findUsersByUserId(Integer userid){
		List<User> users = new ArrayList<User>();
		try {
			users = repository.findByuserid(userid);
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return users;
	}
	
	public List<User> findUsersByTitle(String title){
		List<User> users = new ArrayList<User>();
		try {
			users = repository.findByTitle(title);
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return users;
	}
	
	public List<User> findUsersByBody(String body){
		List<User> users = new ArrayList<User>();
		try {
			users = repository.findByBody(body);
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return users;
	}
	public List<Integer> findDistinctUserId(){
		List<Integer> ids = new ArrayList<Integer>();
		try {
			ids = repository.findDistinctUserId();
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return ids;
	}
	
	public User saveUserAtAnyIndex(int index,User user) {
		List<User> users = new ArrayList<User>();
		User userToUpdate = new User();
		try {
			users = repository.findAll();
			userToUpdate = users.get(--index);
			userToUpdate.setBody(user.getBody());
			userToUpdate.setUserid(user.getUserid());
			userToUpdate.setTitle(user.getTitle());
			repository.save(userToUpdate);
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		
		
		return userToUpdate;
	}
	
	
					
}
