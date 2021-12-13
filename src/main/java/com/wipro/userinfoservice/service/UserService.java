package com.wipro.userinfoservice.service;

import java.util.List;
import java.util.Optional;
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
	
	public User replaceUser(User newUser) {
		return repository.findById(newUser.getId())
			      .map(user -> {
			    	  user.setBody(newUser.getBody());
			    	  user.setTitle(newUser.getTitle());
			        return repository.save(user);
			      }).orElseGet(() -> 
			      		{ return repository.save(newUser);});
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
	
	public User saveUserAtAnyIndex(int index,User user) {
		List<User> users = repository.findAll();
		User userToUpdate = users.get(--index);
		userToUpdate.setBody(user.getBody());
		userToUpdate.setUserid(user.getUserid());
		userToUpdate.setTitle(user.getTitle());
		repository.save(userToUpdate);
		return userToUpdate;
	}
	
	
					
}
