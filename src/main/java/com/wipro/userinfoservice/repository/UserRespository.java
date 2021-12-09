package com.wipro.userinfoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.userinfoservice.bean.User;
@Repository
public interface UserRespository extends JpaRepository<User, Integer> {
	@Query("SELECT DISTINCT u.userid FROM User u")
	List<Integer> findDistinctUserId();
	List<User> findByuserid(Integer userid);
	List<User> findByTitle(String title);
	List<User> findByBody(String title);
		
}
