package org.foto.italy.demo.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(length = 128)
	private String nome;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Foto> foto;
	
	
	public Category(){}
	public Category(String nome) {
		setNome(nome);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Foto> getFoto() {
		return foto;
	}
	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}
	public void addFoto(Foto foto) {
		
		boolean finded = false;
		for (Foto f : getFoto()) {
			
			if (f.getId() == foto.getId())
				finded = true;
		}
		
		if (!finded)
			getFoto().add(foto);
	}
	
	@Override
	public String toString(){
		return "\n" + getId()+"\nil nome della categoria è :" + getNome(); 
	}
	
}
