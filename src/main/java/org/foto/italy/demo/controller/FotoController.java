package org.foto.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.FotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FotoController {

	
	@Autowired
	FotoService fotoServ;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Foto> foto = fotoServ.findAll();
		model.addAttribute("foto",foto);
		return "home";
	}
	@GetMapping("/foto/{id}")
	public String getPIzza(@PathVariable("id") int id, Model model) {
		
		Optional<Foto> optFoto = fotoServ.findById(id);
		
		if (optFoto.isEmpty()) {
			
			System.err.println("Foto non presente con id: " + id);
		}
		
	Foto foto = optFoto.get();
		
		model.addAttribute("foto",foto);
		
		return "foto-show";
	}
	
}
