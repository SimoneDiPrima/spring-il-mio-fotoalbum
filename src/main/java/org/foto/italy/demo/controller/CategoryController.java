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
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FotoService fotoService;
	
	@GetMapping("/admin/category")
	public String getHomeCategory(Model model) {
		List<Category> category = categoryService.findAll();
		model.addAttribute("category",category);
		return "/category";
	}
	@GetMapping("/category/{id}")
	public String getCategory(@PathVariable("id") int id, Model model) {
		
		Optional<Category> optCategory = categoryService.findById(id);
		
		if (optCategory.isEmpty()) {
			
			System.err.println("Categoria non presente con id: " + id);
		}
		
	Category category = optCategory.get();
		
		model.addAttribute("category",category);
		
		return "category-show";
	}
	@GetMapping("/category/admin/create")
	public String createCategory(Model model) {
		
		Category category = new Category();
		model.addAttribute("category", category);
		List<Foto> foto = fotoService.findAll();
		model.addAttribute("foto", foto);
		return "category-create";
	}
	@PostMapping("/category/admin/create")
	public String storeCategory(@Valid @ModelAttribute("category") Category category) {
		
		categoryService.save(category);
		
		return "redirect:/admin/category";
	}
	@GetMapping("/category/admin/update/{id}")
	public String getCategoryUpdate(@PathVariable("id") int id, Model model) {
		
		Optional<Category> optCategory = categoryService.findById(id);
		Category category = optCategory.get();
		model.addAttribute("category", category);
		
		return "category-update";
	}

	@PostMapping("category/admin/update/{id}")
	public String editCategory(
			@PathVariable("id") int id,
			@Valid Category category
		) {
		
		Category oldCat = categoryService.findById(id).get();
		
		categoryService.save(category);
		
		return "redirect:/admin/category";
	}
	@GetMapping("/category/admin/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		
		
		categoryService.deleteById(id);
		
		return "redirect:/admin/category";
	}
}
