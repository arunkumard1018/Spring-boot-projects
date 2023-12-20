package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.exception.UserNotFoundException;
import com.app.jpa.PostRepositry;
import com.app.jpa.UserRepositry;
import com.app.post.Post;
import com.app.users.User;

@Service
public class UserService {
	
	private UserRepositry userRepositry;
	private PostRepositry postRepositry;
	public UserService(UserRepositry userRepositry,PostRepositry postRepositry) {
		super();
		this.postRepositry = postRepositry;
		this.userRepositry = userRepositry;
	}
	
	public List<User> findAllUsers(){
		return userRepositry.findAll();
	}
	
	public User findUser(int userId) {
		Optional<User> user = userRepositry.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("userId : "+userId);
		}else {
			return user.get();
		}
	}
	
	public User addUser(User user) {
		return userRepositry.save(user);
	}
	
	public void deleteUser(int userId) {
		userRepositry.deleteById(userId);
	}
	
	public List<Post> getAllPosts(int userId){
		Optional<User> user = userRepositry.findById(userId);
		if(user.isEmpty()) {
			return null;
		}else {
			return user.get().getPosts();
		}
	}
	
	public boolean createPost(Post post,int userId) {
		Optional<User> user = userRepositry.findById(userId);
		if(user.isEmpty()) {
			return false;
		}else {
			post.setUser(user.get());
			post.setcreatedAt(LocalDateTime.now());
			postRepositry.save(post);
			return true;
		}
		
	}

}
