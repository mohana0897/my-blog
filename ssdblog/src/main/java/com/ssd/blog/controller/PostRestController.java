package com.ssd.blog.controller;

import java.util.List;
import java.util.Optional;

import com.ssd.blog.entity.Post;
import com.ssd.blog.model.PostDto;
import com.ssd.blog.model.Root;
import com.ssd.blog.service.CovidDetails;
import com.ssd.blog.service.PostService;
import com.ssd.blog.service.ResponseValidateService;

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

@RestController
@RequestMapping("blog/api")
public class PostRestController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ResponseValidateService responseValidateService;
	
	@Autowired
	private CovidDetails covidDetails;

	
	@PostMapping("/posts")
	public ResponseEntity<?> addPost(@Validated @RequestBody PostDto postDto, BindingResult bindingResult) {

		if(responseValidateService.validatePost(bindingResult)!=null) {
			
			return responseValidateService.validatePost(bindingResult);
			
			
		}else {
			
			return new ResponseEntity<Post>(postService.addPost(postDto), HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts(@RequestParam(value="pageNo", defaultValue = "0", required = false) int pageNo,
											@RequestParam(value="pageSize", defaultValue = "4", required=false) int pageSize,
											@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
									        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir)
											{
		
		return new ResponseEntity<List<PostDto>>(postService.getAllPosts(pageNo, pageSize, sortDir, sortBy), HttpStatus.OK);
	}
	
	@GetMapping("posts/{id}")
	public ResponseEntity<?> getPostById(@PathVariable Long id){
		
		return new ResponseEntity<Optional<Post>>(postService.getPostById(id), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("posts/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable Long id){
		
		return new ResponseEntity<String>("post deleted", HttpStatus.OK);
		
	}
	
	@GetMapping("cats")
	public ResponseEntity<?> getAllDetails(){
		return new ResponseEntity<Root>(covidDetails.getAllDetails(), HttpStatus.OK);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
