package com.ssd.blog.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@Column(nullable=false, unique=true)
	private String title;


	private String description;


	private String content;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> commentsList;

	public List<Comment> getCommentsList() {
		return commentsList;
	}

	public Post() {
		super();
	}

	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public Post(Long id, String title, String description, String content, List<Comment> commentsList) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.commentsList = commentsList;
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
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", commentsList=" + commentsList + "]";
	}

}
