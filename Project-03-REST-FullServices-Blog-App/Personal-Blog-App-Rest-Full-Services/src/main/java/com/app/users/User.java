package com.app.users;

import java.time.LocalDate;
import java.util.List;
import com.app.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String email;
	private String name;
	private LocalDate birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	public User() {
		super();
	}
	
	public User(int userId, String email, String name, LocalDate birthDate, List<Post> posts) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = posts;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	

}
