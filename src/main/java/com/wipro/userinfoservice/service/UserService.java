package com.wipro.userinfoservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.userinfoservice.bean.User;
import com.wipro.userinfoservice.repository.UserRespository;


@Service
public class UserService {
	@Autowired 
	private UserRespository repository;
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public Optional<User> getUsersById(Integer id){
		return repository.findById(id);
	}
	
	public List<User> findUsersByUserId(Integer userid){
		return repository.findByuserid(userid);
	}
	
	public List<User> findUsersByTitle(String title){
		return repository.findByTitle(title);
	}
	
	public List<User> findUsersByBody(String body){
		return repository.findByBody(body);
	}
	public List<Integer> findDistinctUserId(){
		return repository.findDistinctUserId();
	}
	
	public User saveFourthUser(User fourthUser) {
		List<User> users = repository.findAll();
		User userToSave = new User();
		int index = 0;
		for(User user : users) {
			if(index == 3) {
				userToSave = user;
				break;
			}
			index++;
		}
		userToSave.setTitle(fourthUser.getTitle());
		userToSave.setBody(fourthUser.getBody());
		repository.save(userToSave);
		return userToSave;
	}
	
}
