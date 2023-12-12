package com.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user_details")
public class UserEntity {
	
	
	private String name;
	@Id
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<PostEntity> posts;
	
	public UserEntity() {
	}

	public UserEntity(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 

	public List<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
