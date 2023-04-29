package com.ssd.blog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostDto {

	private Long id;

	@NotBlank(message = "Title cannot be empty")
	@Size(min = 3, message = "minimum 4 charecters required")
	@Size(max = 12, message = "maximum 12 charecters allowed ")
	private String title;

	@NotBlank(message = "description cannot be empty")
	private String description;

	@NotBlank(message = "content cannot be empty")
	private String content;

	public PostDto(Long id,
			@NotBlank(message = "Title cannot be empty") @Size(min = 3, message = "minimum 4 charecters required") @Size(max = 12, message = "maximum 12 charecters allowed ") String title,
			@NotBlank(message = "description cannot be empty") String description,
			@NotBlank(message = "content cannot be empty") String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + "]";
	}

	public PostDto() {
		super();
	}


	
}
