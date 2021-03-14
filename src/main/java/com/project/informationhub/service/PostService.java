package com.project.informationhub.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.model.Post;
import com.project.informationhub.repository.PostRepository;



@Service
public class PostService {
	
	
	@Autowired
	private PostRepository postRepository;
	
	public long createPost(Post post)
	{
		Post newPost = postRepository.save(post);
		
		return newPost.getCommentId();
	}
	
	public long updatePost(Post post)
	{
		if(post.getCommentId() == 0) {
			return 0;
		}
		Post updatedPost = postRepository.save(post);
		
		return updatedPost.getCommentId();
		
		
	}
	
	public Optional<Post> get(int postId)
	{
		return postRepository.findById(postId);
	}
	
	public void delete(int postId)
	{
		Optional<Post>  optionalPost = get(postId);
		if(optionalPost.isPresent()) {
			 postRepository.deleteById(postId);
		}
		
	}
	
	public List<Post> searchPostByWord(String word)
	{
		return postRepository.findByTitleContainingOrDescriptionContaining(word, word);
//		Set<Integer> postIds = new LinkedHashSet<>();
//		for(Post post : posts)
//		{
//			if( post.getTitle().contains(word))
//			{
//				postIds.add(post.getId());
//			}
//		}
//		
//		
//		for(Post post : posts)
//		{
//			if( post.getDescription().contains(word))
//			{
//				postIds.add(post.getId());
//			}
//		}
//		
//		
//		return postIds;
		
	}
	
	
	
	
	

}
