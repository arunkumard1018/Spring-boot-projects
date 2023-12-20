package com.app.users;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.post.Post;
import com.app.service.UserService;

@RestController
public class UserResource {

	private UserService userService;
	public UserResource(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/users/{userId}")
	public User retriveUser(@PathVariable int userId) {
		return userService.findUser(userId);
	}

	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveduser = userService.addUser(user);
		
		/*building the uri of created user*/
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveduser.getUserId())
						.toUri();
		
		/* returning status of 201 with location header*/
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
	}

	@GetMapping("/users/{userId}/posts")
	public List<Post> retriveAllPostsForUser(@PathVariable int userId) {
		return userService.getAllPosts(userId);
	}

	@PostMapping("/users/{userId}/posts")
	public void createPost(@PathVariable int userId,@RequestBody Post post) {
		userService.createPost(post,userId);
	}

}
