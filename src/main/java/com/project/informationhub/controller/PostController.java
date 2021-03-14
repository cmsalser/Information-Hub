package com.project.informationhub.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.model.Post;
import com.project.informationhub.service.PostService;


@RestController
@RequestMapping("post")
public class PostController {
	
	
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public long createPost(@RequestBody Post post)
	{
		long postId = postService.createPost(post);
		
		return postId;
	}
	
	@PutMapping
	public long updatePost(@RequestBody Post post)
	{
		long updatedPostId = postService.createPost(post);
		
		return updatedPostId;
		
		
	}
	
	@GetMapping
	public Optional<Post> get(@PathVariable int postId)
	{
		return postService.get(postId);
	}
	
	@GetMapping(value="searchByWord")
	public List<Post> get(@PathVariable String word)
	{
		return postService.searchPostByWord(word);
	}
	
	
	
	
	@DeleteMapping
	public void delete(@PathVariable int postId)
	{
		postService.delete(postId);
	}

}
