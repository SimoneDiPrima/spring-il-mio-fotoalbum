package org.foto.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.CategoryService;
import org.foto.italy.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class FotoController {

	
	@Autowired
	FotoService fotoServ;
	@Autowired
	CategoryService catServ;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Foto> foto = fotoServ.findAll();
		model.addAttribute("foto",foto);
		return "home";
	}
	@GetMapping("/foto/{id}")
	public String getFoto(@PathVariable("id") int id, Model model) {
		
		Optional<Foto> optFoto = fotoServ.findById(id);
		
		if (optFoto.isEmpty()) {
			
			System.err.println("Foto non presente con id: " + id);
		}
		
	Foto foto = optFoto.get();
		
		model.addAttribute("foto",foto);
		
		return "foto-show";
	}
	@GetMapping("/foto/create")
	public String createFoto(Model model) {
		
		Foto foto = new Foto();
		model.addAttribute("foto", foto);
		List<Category> categories = catServ.findAll();
		model.addAttribute("categories",categories);
		
		return "foto-create";
	}
	@PostMapping("/foto/create")
	public String storeFoto(@Valid @ModelAttribute("foto") Foto foto) {
		
		fotoServ.save(foto);
		
		return "redirect:/";
	}
	@GetMapping("/foto/update/{id}")
	public String getFotoUpdate(@PathVariable("id") int id, Model model) {
		
		Optional<Foto> optFoto = fotoServ.findById(id);
		Foto foto = optFoto.get();
		model.addAttribute("foto", foto);
		List<Category> categories = catServ.findAll();
		model.addAttribute("categories",categories);
		return "foto-update";
	}
	@PostMapping("/foto/update")
	public String updateFoto(@Valid Foto foto) {
		
		fotoServ.save(foto);
		
		return "redirect:/";
	}
	@GetMapping("/foto/delete/{id}")
	public String deleteFoto(@PathVariable("id") int id) {
		
		Optional<Foto> optFoto = fotoServ.findById(id);
		Foto foto = optFoto.get();
		
		fotoServ.delete(foto);
		
		return "redirect:/";
	}
	
}
