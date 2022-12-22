package org.foto.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.repo.CategoryRepo;
import org.foto.italy.demo.repo.FotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

	@Autowired
	private FotoRepo fotoRepo;
	@Autowired
	private CategoryRepo catRepo;
	
	public void save(Foto foto) {
		fotoRepo.save(foto);
	}
	public void deleteCategory(Category category) {
		catRepo.delete(category);
	}
	public void delete(Foto foto) {
		fotoRepo.delete(foto);
		
	}
	public void deleteById(int id) {
		fotoRepo.deleteById(id);
	}
	public List<Foto> findAll(){
		return fotoRepo.findAll();
	}
	public Optional<Foto> findById(int id) {
		
		return fotoRepo.findById(id);
	}
}
