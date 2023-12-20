package com.app.post;

import java.time.LocalDateTime;

import com.app.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "post_details")
public class Post {
	
	@Id
	@GeneratedValue
	private int post_id;
	private String title;
	private String description;
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	

	public Post() {
		super();
	}

	public Post(int post_id, String title, String description, LocalDateTime createdAt, User user) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.user = user;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
