package com.project.informationhub.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.Post;
import com.project.informationhub.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.dto.PostDTO;
import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.PostUpvotes;
import com.project.informationhub.repository.PostUpvotesRepository;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.utils.Constants;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	

	@Autowired
	private PostUpvotesRepository postUpvotesRepository;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	ThreadRepository threadRepository;
	
	public long createPost(PostDTO postDTO)
	{
		Thread thread = threadRepository.findById(postDTO.getThreadID()).get();
		Post post = new Post(thread, postDTO.getTitle(), postDTO.getDescription());
		post.setTimestampCreated(new Date());
		post.setTimestampEdited(new Date());
		Post newPost = postRepository.save(post);
		
		notificationService.sendPostNotification(newPost, "New Post created", "New post has been created in your thread.");
		
		return newPost.getId();
	}
	
	public long updatePost(Post post)
	{
//<<<<<<< HEAD
//		if(post.getCommentId() == 0) {
//			return 0;
//		}
//		Post updatedPost = postRepository.save(post);
//
//		return updatedPost.getCommentId();
//=======
		// if(post.getId() == 0) {
		// 	return 0;
		// }
		// post.setTimestampCreated(new Date());
		// post.setTimestampEdited(new Date());
		// Post updatedPost = postRepository.save(post);

		// return updatedPost.getId();

		// post.setId(id);

		if(post.getId() == 0) {
			return 0;
		}
		//post.setTimestampCreated(new Date());
		post.setTimestampEdited(new Date());
		return postRepository.save(post).getId();
	}

	public Optional<Post> get(long postId)
	{
		
		return postRepository.findById(postId);
	}
	
	public ResponseDto getPostByThread(Long threadId)
	{	
		ResponseDto responseDto = new ResponseDto();
		responseDto.setCode(200);
		responseDto.setStatus(Constants.STATUS_SUCCESS);
		List<Post> posts = postRepository.findByThreadID(threadId);
		posts.sort((Post p1, Post p2)-> Integer.compare(p1.getUpvotes().size(), p2.getUpvotes().size()));
		responseDto.setData(posts);
		return responseDto;
		
	}
	
	public ResponseDto upvotePost(long postId, long userId)
	{	
		ResponseDto responseDto = new ResponseDto();
		
		Optional<Post> isPost = get(postId);
		if(isPost.isPresent()) {
			PostUpvotes postUpvotes = postUpvotesRepository.findByUserIdAndPost(userId, isPost.get());
			if(Objects.isNull(postUpvotes)) {
				responseDto.setStatus(Constants.STATUS_SUCCESS);
				responseDto.setCode(200);
				PostUpvotes updatePostVotes = new PostUpvotes();
				updatePostVotes.setPost(isPost.get());
				updatePostVotes.setUserId(userId);
				postUpvotesRepository.save(updatePostVotes);
			} 
			else {
				responseDto.setStatus(Constants.STATUS_IGNORED);
				responseDto.setCode(201);
				responseDto.setMessage("already upvoted");
			}
			
			
		} 
		else {
			responseDto.setStatus(Constants.STATUS_FAILED);
			responseDto.setCode(404);
		}
		return responseDto;
	}
	
	public ResponseDto stickiedPost(long postId)
	{	
		ResponseDto responseDto = new ResponseDto();
		
		Optional<Post> isPost = get(postId);
		if(isPost.isPresent()) {
			List<Post> posts = postRepository.findByThreadIDAndStickied(isPost.get().getThread().getThreadID(), Boolean.TRUE);
			if(Objects.isNull(posts) || posts.isEmpty()) {
				Post post = isPost.get();
				post.setStickied(Boolean.TRUE);
				postRepository.save(post);
				responseDto.setStatus(Constants.STATUS_SUCCESS);
				responseDto.setCode(200);
				
			} 
			else {
				responseDto.setStatus(Constants.STATUS_IGNORED);
				responseDto.setCode(201);
				responseDto.setMessage("already stickied post is available");
			}
			
			
		} 
		else {
			responseDto.setStatus(Constants.STATUS_FAILED);
			responseDto.setCode(404);
		}
		return responseDto;
	}
	
	public ResponseDto delete(long postId)
	{
		ResponseDto response = new ResponseDto();
		Optional<Post> optionalPost = get(postId);
		if(optionalPost.isPresent()) {
			response.setCode(200);
			response.setStatus(Constants.STATUS_SUCCESS);
			 postRepository.deleteById(postId);
		} 
		else {
			response.setCode(404);
			response.setMessage("Post id incorrect");
			response.setStatus(Constants.STATUS_FAILED);
		}
		return response;
	}
	
	public List<Post> searchPostByWord(String word, int mostUpvoted)
	{
		List<Post> posts =  postRepository.findByTitleContainingOrDescriptionContaining(word, word);
		if(mostUpvoted == 1) {
			posts = posts.stream().sorted(Comparator.comparingInt(d -> d.getUpvotes().size())).collect(Collectors.toList());
			Collections.reverse(posts);
		}
		return posts;


	}
	
	public ResponseDto changeAnonymous(long postId, boolean anonymous)
	{
		ResponseDto response = new ResponseDto();
		Optional<Post> optionalPost = get(postId);
		if(optionalPost.isPresent()) {
			response.setCode(200);
			response.setStatus(Constants.STATUS_SUCCESS);
			Post post = optionalPost.get();
			post.setAnonymous(anonymous);
			postRepository.save(post);
		} 
		else {
			response.setCode(404);
			response.setMessage("Post id incorrect");
			response.setStatus(Constants.STATUS_FAILED);
		}
		return response;
	}
}