package com.example.universityboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universityboard.model.BlogDTO;
import com.example.universityboard.model.BlogDetails;
import com.example.universityboard.model.Comment;
import com.example.universityboard.repository.BlogRepository;
import com.example.universityboard.repository.CommentRepository;

@Service
public class BlogServiceImpl {

	@Autowired
	BlogRepository blogRepository;

	@Autowired
	CommentRepository commentRepository;

	public List<BlogDetails> getAllblogs() {
		return blogRepository.findAll();
	}

	public BlogDetails updateBlog(BlogDetails blogDetails) {
		Optional<BlogDetails> optionalblogDetails = blogRepository.findById(blogDetails.getBlogId());
		BlogDetails bd = null;
		if (optionalblogDetails.isPresent()) {
			bd = optionalblogDetails.get();
			bd.setBlogTitle(blogDetails.getBlogTitle());
			bd.setBody(blogDetails.getBody());
		}

		return this.blogRepository.save(bd);
	}

	public BlogDetails saveBlog(BlogDetails blogDetails) {
		return this.blogRepository.save(blogDetails);

	}

	public List<BlogDetails> getBlogbyAuthorName(String authorName) {
		return blogRepository.findByBlogAuthor(authorName);
	}

	public BlogDTO getBlogbyId(String id) {
		BlogDetails blog = blogRepository.findById(id).orElse(null);
		List<Comment> comments = commentRepository.findByBlogId(blog.getBlogId());
		BlogDTO blogdto = new BlogDTO(blog.getBlogId(), blog.getBlogTitle(), blog.getBlogAuthor(), blog.getBody(),
				comments);
		return blogdto;
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}
}
