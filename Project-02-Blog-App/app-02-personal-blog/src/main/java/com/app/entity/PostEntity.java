package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "post_details")
public class PostEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String heading;

	private String Description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;

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

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostEntity [id=" + id + ", title=" + title + ", heading=" + heading + ", Description=" + Description
				+ ", user=" + user + "]";
	}
	
	
	

}
