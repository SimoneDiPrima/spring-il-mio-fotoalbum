package org.foto.italy.demo.api.controller;

import java.util.List;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.CategoryService;
import org.foto.italy.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1/foto")
@CrossOrigin("*")
public class FotoApiController {
	
	@Autowired
	private FotoService fotoServ;
	@Autowired
	private CategoryService catServ;
	
	@GetMapping("/all")
	public List<Foto> getAllPhotos() {
		
		List<Foto> photos = fotoServ.findAll();
		List<Category> categories = catServ.findAll();
		return photos;
	}
}
