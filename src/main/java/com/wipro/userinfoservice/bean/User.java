package com.wipro.userinfoservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	 
	 @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 
	 @Column(name="userid") 
	 private int userid;
	
	//@Column(name="title")
	private String title;
	
	
	 //@Column(name="body") 
	 private String body;
	 

	
	

	public User(int id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User(int userid, int id, String title, String body) {
		super();
		this.userid = userid;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	
	

	

	

	
	

	
	
}
