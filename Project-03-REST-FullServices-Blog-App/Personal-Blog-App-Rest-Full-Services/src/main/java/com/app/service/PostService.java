package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.jpa.PostRepositry;
import com.app.post.Post;

@Service
public class PostService {
	
	private PostRepositry postRepositry;
	public PostService(PostRepositry postRepositry) {
		super();
		this.postRepositry = postRepositry;
	}
	
	public List<Post> retriveAllPost(){
		return postRepositry.findAll();
	}
	
	
}
