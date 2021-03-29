package com.project.informationhub.controller;

import java.util.List;
import java.util.Optional;

import com.project.informationhub.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.service.PostService;


@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("")
	public long createPost(@RequestBody Post post)
	{
		return postService.createPost(post);
	}
	
	@PutMapping("")
	public long updatePost(@RequestBody Post post) {
		// post.setId(id);
		return postService.updatePost(post);
	}
	
	@GetMapping("/{postId}")
	public Optional<Post> get(@PathVariable long postId)
	{
		return postService.get(postId);
	}

	@GetMapping("/bythread/{threadId}")
	public ResponseDto getPostByThread(@PathVariable int threadId)
	{
		return postService.getPostByThread(threadId);
	}
	
	@GetMapping("/searchByWord/{word}")
	public List<Post> getByWord(@PathVariable String word, @RequestParam(value  = "mostUpvoted") int mostUpvoted)
	{
		return postService.searchPostByWord(word, mostUpvoted);
	}
	
	@PutMapping("/upvote/{userId}/{postId}")
	public ResponseDto upvotePost(@PathVariable long postId, @PathVariable long userId)
	{
		return postService.upvotePost(postId, userId);
	}
	
	@PutMapping("/stickied/{postId}")
	public ResponseDto stickiedPost(@PathVariable long postId)
	{
		return postService.stickiedPost(postId);
	}
	
	@PatchMapping("/anonymous/{postId}/{anonymous}")
	public ResponseDto changeAnonymous(@PathVariable long postId, @PathVariable boolean anonymous)
	{
		return postService.changeAnonymous(postId, anonymous);
	}
	
	
	@DeleteMapping("/{postId}")
	public ResponseDto delete(@PathVariable int postId)
	{
		return postService.delete(postId);
	}

}
