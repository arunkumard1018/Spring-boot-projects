package com.app.post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.PostService;

@RestController
public class PostResource {
	
	private PostService postService;
	public PostResource(PostService postService) {
		super();
		this.postService = postService;
	}

	@GetMapping("/posts")
	public List<Post> retriveAllPost(){
		return postService.retriveAllPost();
	}

}
