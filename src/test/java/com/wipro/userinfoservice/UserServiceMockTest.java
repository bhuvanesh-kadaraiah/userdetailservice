package com.wipro.userinfoservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wipro.userinfoservice.bean.User;
import com.wipro.userinfoservice.repository.UserRespository;
import com.wipro.userinfoservice.service.UserService;

public class UserServiceMockTest {
	
	@Mock
	private UserRespository repo;
	
	@InjectMocks
	private UserService service;
	
	
	
	@BeforeEach
	public void setMockOutput() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getUserById() {
		List<User> usersMocked = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setUserid(1);
		user1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		user1.setBody("est rerum tempore vitae\\\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\\\nqui aperiam non debitis possimus qui neque nisi nulla");
		
		User user2 = new User();
		user2.setId(2);
		user2.setUserid(1);
		user2.setTitle("qui est esse");
		user2.setBody("quia et suscipit\\\\nsuscipit recusandae consequuntur expedita et cum\\\\nreprehenderit molestiae ut ut quas totam\\\\nnostrum rerum est autem sunt rem eveniet architecto");
		
		usersMocked.add(user1);
		usersMocked.add(user2);
		when(repo.findAll()).thenReturn(usersMocked);
		
		List<User> users = service.getAllUsers();
		assertEquals(usersMocked.size(),users.size());
		
	}
	
	@Test
	public void getUserByTitle() {
		List<User> usersMocked = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setUserid(1);
		user1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		user1.setBody("est rerum tempore vitae\\\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\\\nqui aperiam non debitis possimus qui neque nisi nulla");
		
				
		usersMocked.add(user1);
				
		when(repo.findByTitle(user1.getTitle())).thenReturn(usersMocked);
		
		List<User> users = service.findUsersByTitle(user1.getTitle());
		
		assertEquals(usersMocked.get(0).getId(),users.get(0).getId());
		assertEquals(usersMocked.get(0).getUserid(),users.get(0).getUserid());
		assertEquals(usersMocked.get(0).getTitle(),users.get(0).getTitle());
		assertEquals(usersMocked.get(0).getBody(),users.get(0).getBody());
		
		
	}
		
	@Test
	public void getDistinctUserId() {
		List<Integer> userIds = new ArrayList<Integer>();
		userIds.add(1);
		userIds.add(2);
		when(repo.findDistinctUserId()).thenReturn(userIds);
		List<Integer> uids = service.findDistinctUserId();
		assertEquals(new Integer(1),uids.get(0));
		assertEquals(new Integer(2),uids.get(1));
	}
}
