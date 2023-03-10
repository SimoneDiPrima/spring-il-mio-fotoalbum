package org.foto.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.foto.italy.demo.pojo.Role;
import org.foto.italy.demo.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;
	
	public void save(Role role) {
		roleRepo.save(role);
	}
	public void delete(Role role) {
		roleRepo.delete(role);
	}
	public Role getById(int id){
		return roleRepo.findById(id).get();
	}
	public List<Role> findAll(){
		return roleRepo.findAll();
	}
}
