package com.ssd.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.model.CommentDto;
import com.ssd.blog.service.CommentService;
import com.ssd.blog.service.ResponseValidateService;

@RestController
@RequestMapping("post/api")
public class CommentRestController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ResponseValidateService responseValidateService;
	
	
	@PostMapping("post/{id}/comments")
	public ResponseEntity<?> createComment(@Validated @RequestBody CommentDto commentDto, @PathVariable Long id, BindingResult bindingResult){
		
		if(responseValidateService.validatePost(bindingResult)==null) {
		
		return new ResponseEntity<CommentDto>(commentService.addComment(commentDto, id), HttpStatus.CREATED);
		
	}else {
		
		return responseValidateService.validatePost(bindingResult);
		
	}
	
}
	
	@GetMapping("post/{id}/comments")
	
	public ResponseEntity<?> getAllCommentsForAPost(@RequestParam(value="pageNo", defaultValue = "1", required = false) int pageNo,
											@RequestParam(value="pageSize", defaultValue = "4", required=false) int pageSize,
											@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
									        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
									       @PathVariable Long id)
											{
											
		return new ResponseEntity<List<CommentDto>>(commentService.getAllCommentsByPostId(pageNo, pageSize, sortDir, sortBy, id), HttpStatus.OK);
												
											}



	@DeleteMapping("comments/{id}") 
	public ResponseEntity<?> deleteCommentById(@PathVariable Long id){
		
		commentService.deleteCommentById(id);
		
		return new ResponseEntity<String>("comment successfully deleted", HttpStatus.OK);
		
	}





}
