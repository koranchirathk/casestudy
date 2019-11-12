package com.example.universityboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universityboard.model.BlogDTO;
import com.example.universityboard.model.BlogDetails;
import com.example.universityboard.model.Comment;
import com.example.universityboard.service.BlogServiceImpl;

@RestController
@RequestMapping("/bog")
public class BlogController {
	

	@Autowired
	private BlogServiceImpl blogServiceImpl;
	
	@GetMapping("/getallblogs")
	public List<BlogDetails> getAllBlogs() {
		return blogServiceImpl.getAllblogs();
	}
	
	@PostMapping("/addblog")
	public BlogDetails addBlog(@RequestBody BlogDetails blogDetails) {
		return this.blogServiceImpl.saveBlog(blogDetails);
	}
	
	
	@PutMapping("/updateblog")
	public BlogDetails updateGroup(@RequestBody BlogDetails blogDetails) {
		return this.blogServiceImpl.updateBlog(blogDetails);
	}
	
	@GetMapping("/getblogbyauthonamer/{authorName}")
	public List<BlogDetails> getGroupByNameblog(@PathVariable String authorName) {
		return blogServiceImpl.getBlogbyAuthorName(authorName);
	}

	
	@GetMapping("/getblogbyId/{id}")
	public BlogDTO getBlogbyId(@PathVariable String id) {
		return blogServiceImpl.getBlogbyId(id);
	}
	
	@PostMapping("/addcomment")
	public Comment addComment(@RequestBody Comment comment) {
		return this.blogServiceImpl.saveComment(comment);
	}
}
