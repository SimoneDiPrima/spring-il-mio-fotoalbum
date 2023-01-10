package org.foto.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Comment;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	
	public Comment save(Comment comment) {
		return commentRepo.save(comment);
	}
	public void delete(Comment comment) {
		commentRepo.delete(comment);
	}

	
	public List<Comment> findAll(){
		return commentRepo.findAll();
	}
	public Optional<Comment> findById(int id) {
		
		return commentRepo.findById(id);
	}
}
