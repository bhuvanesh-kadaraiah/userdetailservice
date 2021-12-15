package com.wipro.userinfoservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.hamcrest.Matchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.userinfoservice.bean.User;
import com.wipro.userinfoservice.controller.UserController;
import com.wipro.userinfoservice.service.UserService;

@WebMvcTest(controllers = UserController.class)
public class UserControllerMockTest {
	 @Autowired                           
	    private MockMvc mockMvc;  
	                                                 
	    @MockBean                           
	    private UserService userService; 
	                                               
	    private List<User> userList;  
	    
	    private static ObjectMapper mapper = new ObjectMapper();
	    
	    @BeforeEach                           
	    void setUp() {                               
	       this.userList = new ArrayList<>();
	       this.userList.add(new User(1,1, "title1", "Body1")); 
	       this.userList.add(new User(2,1, "title2", "Body2"));
	       this.userList.add(new User(3,1, "title3", "Body3"));                                                       
	 
	    }
	    
	    @Test
	    public void testGetAllUsers() throws Exception {
	        Mockito.when(userService.getAllUsers()).thenReturn(userList);
	        mockMvc.perform(get("/user/all")).andExpect(status().isOk());
	    }
	    
	    
	    @Test
	    public void testGetUserByTitle() throws Exception {
	    	List<User> user = new ArrayList<User>();
	        Mockito.when(userService.findUsersByTitle("title3")).thenReturn(user);
	        mockMvc.perform(get("/user/title/title3")).andExpect(status().isOk());
	    }
	    
	    @Test
	    public void testGetUserById() throws Exception {
	    	Optional<User> user = Optional.ofNullable(new User(1,1,"Title","Body"));
	        Mockito.when(userService.getUsersById(1)).thenReturn(user);
	        mockMvc.perform(get("/user/id/"+1)).andExpect(status().isOk())
	        	.andExpect(jsonPath("$.id").value(1))
	        	.andExpect(jsonPath("$.userid").value(1))
	        	.andExpect(jsonPath("$.title").value("Title"))
	        	.andExpect(jsonPath("$.body").value("Body"));
	    }
	    
	    @Test
	    public void testGetUserByBody() throws Exception {
	    	 List<User> users = new ArrayList<User>();  
	    	 users.add(new User(1,1, "title1", "Body1"));
	    	List<User> user = new ArrayList<User>();
	        Mockito.when(userService.findUsersByBody("Body3")).thenReturn(users);
	        mockMvc.perform(get("/user/body/Body3")).andExpect(status().isOk());
	    }
	    
	    
	
}
