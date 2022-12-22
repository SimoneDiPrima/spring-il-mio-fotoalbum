package org.foto.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public void save(Category category) {
		categoryRepo.save(category);
	}
	public void delete(Category category) {
		categoryRepo.delete(category);
	}
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	public Optional<Category> findById(int id) {
		
		return categoryRepo.findById(id);
	}
	public void deleteById(int id) {
	categoryRepo.deleteById(id);
	
	}
}

