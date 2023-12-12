package com.app.service;

import java.util.List;

import com.app.entity.PostEntity;
import com.app.entity.UserEntity;
import com.app.jpa.PostRepositry;
import com.app.jpa.UserRepositry;

public class PostService {
	PostRepositry postRepositry;
	UserRepositry userRepositry;
	public PostService(PostRepositry postRepositry, UserRepositry userRepositry) {
		super();
		this.postRepositry = postRepositry;
		this.userRepositry = userRepositry;
	}


	public PostService(PostRepositry postRepositry) {
		super();
		this.postRepositry = postRepositry;
	}
	
	
	public void savePost(PostEntity post) {
		postRepositry.save(post);
	}
	
	
	public List<PostEntity> retriveAllPosts(String email){
		try{
			UserEntity user = userRepositry.getReferenceById(email);
			return user.getPosts();
			
		}catch (Exception e) {
			return null;
		}
	}
	
	public boolean createPost(String email,PostEntity post){
		
		try{
			UserEntity user = userRepositry.getReferenceById(email);
			post.setUser(user);
			postRepositry.save(post);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
}
