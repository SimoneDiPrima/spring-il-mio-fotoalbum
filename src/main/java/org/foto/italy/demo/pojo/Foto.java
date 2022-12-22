package org.foto.italy.demo.pojo;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Foto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotNull
	@Column(length = 128)
	private String titolo;


	
	@NotNull(message="descriptiom must not be null")
	@Size(min=10, max=130, message="description must be more than 10 charachters")
	@Column(name="description", length=130)
	private String descrizione;
	
	
	private String url;
	
	private String tag;
	
	private Boolean visible;
	
	@ManyToMany
	 private List<Category> categories;
	
	public Foto() {}
	public Foto(String titolo,String descrizione,String url) {
		setTitolo(titolo);
		setDescrizione(titolo);
		setUrl(url);
	}
	public Foto(String titolo,String descrizione,String url,Boolean visible) {
		this(titolo,descrizione,url);
		setVisible(visible);
		
	}
	public Foto(String titolo,String descrizione,String url,Boolean visible,String tag) {
		this(titolo,descrizione,url,visible);
		setTag(tag);
	}
	public Foto(String titolo,String descrizione,String url,Category... categories) {
		this(titolo,descrizione,url);
		setCategories(Arrays.asList(categories));
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public void addCategory(Category category) {
		
		boolean finded = false;
		for (Category c : getCategories()) {
			
			if (c.getId() == category.getId())
				finded = true;
		}
		
		if (!finded)
			getCategories().add(category);
	}
	
		
	@Override
	public String toString(){
		return "\n" + getId()+"\nil nome della foto è :" + getTitolo()
		+ "\nla sua descrizione:"+ getDescrizione(); 
	}

	

}
