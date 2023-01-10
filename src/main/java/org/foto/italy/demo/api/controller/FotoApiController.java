package org.foto.italy.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Comment;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.CategoryService;
import org.foto.italy.demo.service.CommentService;
import org.foto.italy.demo.service.FotoService;
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
@RequestMapping("api/1/foto")
@CrossOrigin("*")
public class FotoApiController {
	
	@Autowired
	private FotoService fotoServ;
	@Autowired
	private CategoryService catServ;
	@Autowired
	private CommentService commServ;
	
	@GetMapping("/all")
	public List<Foto> getAllPhotos() {
		
		List<Foto> photos = fotoServ.findAll();
		List<Category> categories = catServ.findAll();
		return photos;
	}
	@PostMapping("/{id}/comment/post")
	public Comment postComment(
			@PathVariable("id") int id,
			@Valid @RequestBody Comment comment
			
	) {
		
		Optional<Foto> photoOpt = fotoServ.findById(id);
		
		if (photoOpt.isEmpty()) return null;
		
		Foto foto = photoOpt.get();
		comment.setFoto(foto);
		
		return commServ.save(comment);
	}
}
