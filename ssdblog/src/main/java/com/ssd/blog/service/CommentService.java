package com.ssd.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssd.blog.entity.Comment;
import com.ssd.blog.entity.Post;
import com.ssd.blog.exceptions.PostResponseException;
import com.ssd.blog.model.CommentDto;
import com.ssd.blog.repository.CommentRepository;
import com.ssd.blog.repository.PostRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CommentDto addComment(CommentDto commentDto, Long id) {

		Post post = postRepository.findById(id).orElseThrow(() -> new PostResponseException("ID not registered"));

		Comment comment = modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment c = commentRepository.save(comment);
		
		CommentDto cdto=modelMapper.map(c, CommentDto.class);

		return cdto;
	}
	
	
	public List<CommentDto> getAllCommentsByPostId(int pageNo, int pageSize, String sortDir, String sortBy, Long id){
		
		List<CommentDto> allCommentsforAPost = new ArrayList<>();
		
		
		
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
								:Sort.by(sortBy).descending();
		
		PageRequest.of(pageNo, pageSize, sort);
		
		commentRepository.findAll(PageRequest.of(pageNo, pageSize, sort)).getContent().forEach(comment->{
		
									CommentDto commentDto= modelMapper.map(comment, CommentDto.class);
		
									allCommentsforAPost.add(commentDto);
									
		});
		
		return allCommentsforAPost;
		
	}
	
	
	public void deleteCommentById(Long id) {
		
		Comment comment= commentRepository.findById(id).orElseThrow();
		
		commentRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
