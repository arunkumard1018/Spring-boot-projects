package com.app.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.PostEntity;
import com.app.entity.UserEntity;
import com.app.jpa.PostRepositry;
import com.app.jpa.UserRepositry;


@RestController
public class UserResorce {
	
	private UserRepositry userRepositry;
	private PostRepositry postRepositry;
	public UserResorce(UserRepositry userRepositry, PostRepositry postRepositry) {
		super();
		this.userRepositry = userRepositry;
		this.postRepositry = postRepositry;
	}



	@GetMapping("/users")
	public List<UserEntity> retriveAllUsers() {
		return userRepositry.findAll();
		
	}
	@GetMapping("/users/{email}")
	public Optional<UserEntity> retriveUsers(@PathVariable String email) {
		return userRepositry.findById(email);	
	}
	
	@PostMapping("/users")
	public void createUsers(@RequestBody UserEntity user){
		userRepositry.save(user);
	}
	@DeleteMapping("/users/{email}")
	public void deleteUsers(@PathVariable String email) {
		userRepositry.deleteById(email);
	}
	
	@GetMapping("/users/{email}/posts")
	public List<PostEntity> retriveAllPostsforUser(@PathVariable String email){
		
		Optional<UserEntity> user = userRepositry.findById(email);
		if(user.isEmpty()) {
			throw new RuntimeException();
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{email}/posts")
	public void createPostforUser(@PathVariable String email,@RequestBody PostEntity post){
		
		Optional<UserEntity> user = userRepositry.findById(email);
		if(user.isEmpty()) {
			throw new RuntimeException();
		}
		post.setUser(user.get());
		postRepositry.save(post);
	}

	
	
	@GetMapping("/posts")
	public List<PostEntity> retriveAllPosts(){
		return postRepositry.findAll();
		
	}
	
}
