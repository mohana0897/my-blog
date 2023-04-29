package com.ssd.blog.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String content;
	
	@Column(nullable=false)
	private String email;

	@ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY )
	@JoinColumn(name="post_id")
	private Post post;

	public Comment() {
		super();
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment(Long id, String content, String email, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.email = email;
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", email=" + email + ", post=" + post + "]";
	}

}
