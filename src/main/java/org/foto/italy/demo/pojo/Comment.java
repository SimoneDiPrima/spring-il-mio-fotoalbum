package org.foto.italy.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String text;
	
	@ManyToOne
	@JsonIgnore
	private Foto foto;
	
	public Comment() {}
	public Comment(String username,String text) {
		setUsername(username);
		setText(text);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setFoto(Foto foto){
		this.foto = foto;
	}
	public Foto getFoto() {
		return foto;
	}

	

	@Override
	public String toString() {
		
		return super.toString() + getUsername() + " - " + getText();
	}

}
