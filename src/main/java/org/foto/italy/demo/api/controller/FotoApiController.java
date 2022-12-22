package org.foto.italy.demo.api.controller;

import java.util.List;

import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/foto")
@CrossOrigin("*")
public class FotoApiController {
	
	@Autowired
	private FotoService fotoServ;
	
	@GetMapping("/all")
public List<Foto> getAllFoto() {
		return fotoServ.findAll();
	}
}
