package org.generation.italy.pojo;

import java.util.List;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	@NotBlank(message = "Il titolo della foto non può essere vuoto")
	private String title;
	
	@Lob
	private String description;
	
	@URL(message="URL non valido")
	@NotBlank(message = "L'URL non può essere vuoto")
	private String imgUrl;
	
	@NotNull
	private Boolean visible;
	
	@ManyToMany
	private List<Category> categories;
	
	
	public Photo (){}
	public Photo (String title, String description, String imgUrl, Boolean visible) {
		setTitle(title);
		setDescription(description);
		setImgUrl(imgUrl);
		setVisible(visible);
	}
	
	public Photo(String title, String description, String imgUrl, Boolean visible, List<Category> categories) {
		this(title, description, imgUrl, visible);
		setCategories(categories);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	
	@Override
	public String toString() {
	
		return "Foto: (" +  getId() + ")" + " - " + getTitle() +
				 "\nDescrizione: " + getDescription() +
				 "\nURL: " + getImgUrl() +
				 "\nVisibile?: " + getVisible();
	}
}
