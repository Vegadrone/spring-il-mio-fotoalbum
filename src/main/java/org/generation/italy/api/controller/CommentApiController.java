package org.generation.italy.api.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.generation.italy.pojo.Comment;
import org.generation.italy.pojo.Photo;
import org.generation.italy.service.CommentService;
import org.generation.italy.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/1/comments")
@CrossOrigin("*")
public class CommentApiController {
	@Autowired
	PhotoService pS;
	
	@Autowired
	CommentService cS;
	
	@GetMapping("/all/photo/{id}")
	public List<Comment> getCommentsPerPhoto(@PathVariable("id") int id) {
		
		Optional<Photo> pOpt = pS.findPhotoById(id);
		Photo photo = pOpt.get();
		List<Comment> comments = photo.getComments();
		
		Collections.reverse(comments);
		return comments;
	}
	
	
	@PostMapping("/add/photo/{id}")
	public Comment addCommentsAtPhoto(@Valid @RequestBody Comment comment,
			@PathVariable("id") int id) {
		
		
		Optional<Photo> pOpt = pS.findPhotoById(id);
		Photo photo = pOpt.get();
		
		Comment newComment = new Comment(comment.getText(), photo);
		
		cS.save(newComment);
		
		List<Comment> comments = photo.getComments();
		
		comments.add(newComment);
	
		return newComment;
			
	}
	
}
