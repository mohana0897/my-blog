package com.ssd.blog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentDto {

	
	private Long id;
	
	@NotBlank
	@NotNull
	@Size(min=5, message = "minimum 5 charecters required")
	@Size(max=120, message = "max 120 charecters allowed")
	private String content;
	private String email;
	
	

	public CommentDto() {
		super();
	}


	public CommentDto(String content, String email) {
		super();
		this.content = content;
		this.email = email;
	}

	
	public Long getId() {
		return id;
	}
	
	
	


	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CommentDto(Long id, String content, String email) {
		super();
		this.id = id;
		this.content = content;
		this.email = email;
	}
	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", content=" + content + ", email=" + email + "]";
	}
	
	
	
}
