package com.ssd.blog.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssd.blog.entity.Post;
import com.ssd.blog.exceptions.PostResponseException;
import com.ssd.blog.model.PostDto;
import com.ssd.blog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Post addPost(PostDto postDto) {
		
		//return postRepository.save(post);
		//Post p= dtoConverter.dtoToModel(postDto);
	Post post=modelMapper.map(postDto, Post.class);
		//return postRepository.save(p);
	try {
	return postRepository.save(post);
	}catch (Exception e) {
		throw new PostResponseException("Post already exists!");
	}
	}
	
	public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortDir, String sortBy){
		
		List<PostDto> allPosts = new ArrayList<>();
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		postRepository.findAll(pageable).getContent().stream().forEach(post->{
			
			PostDto dto = modelMapper.map(post, PostDto.class);
			allPosts.add(dto);
			
		});
		
		return allPosts;
		
	}
	
	
	public Optional<Post> getPostById(Long id) {
		
		return postRepository.findById(id);
		
	}
	
	
	public void deletePostById(Long id) {
		
		Post post= modelMapper.map(id, Post.class);
		
		postRepository.deleteById(post.getId());
		
	}
	

}
