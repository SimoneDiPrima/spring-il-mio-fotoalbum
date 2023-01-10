package org.foto.italy.demo.pojo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	private String descrizione;
	
	
	private String url;
	
	private String tag;
	
	private Boolean visible;
	
	@OneToMany(mappedBy = "foto")
	private Set<Comment> comments;
	
	
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
	public Foto(String titolo,String descrizione,String url,Boolean visible,Category category) {
		this(titolo,descrizione,url,visible);
		setCategories(categories);
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
	
	public Set<Comment> getComments() {
		return comments;
	}
	public Foto setComments(Set<Comment> comments) {
		
		this.comments = comments;
		
		return this;
	}
	// this method use `fluent interface` to gain possibility
	// to use chain method calls: 
	// obj.meth1().meth2().meth3();
	// check Spring...Application.java for more info
	public Foto addComment(Comment comment) {
		
		if (getComments() == null) setComments(new HashSet<>());
		
		getComments().add(comment); 
		
		return this;
	}
	
		
	@Override
	public String toString(){
		return "\n" + getId()+"\nil nome della foto è :" + getTitolo()
		+ "\nla sua descrizione:"+ getDescrizione(); 
	}

	

}
