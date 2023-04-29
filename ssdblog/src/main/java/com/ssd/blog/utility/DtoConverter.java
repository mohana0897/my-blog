package com.ssd.blog.utility;

import org.springframework.stereotype.Component;

import com.ssd.blog.entity.Post;
import com.ssd.blog.model.PostDto;

@Component
public class DtoConverter {

	public PostDto modelToDto(Post post) {
		
		PostDto postDto = new PostDto();
		
		postDto.setId(post.getId());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());
		postDto.setTitle(post.getTitle());
		
		return postDto;
	
	}
	
	public Post dtoToModel(PostDto postDto) {
		
		
		Post post= new Post();
		
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		
		return post;
	}
	
}
