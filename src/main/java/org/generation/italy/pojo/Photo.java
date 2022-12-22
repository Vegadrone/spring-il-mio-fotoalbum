package org.generation.italy.pojo;

import java.util.List;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@Column(name = "description")
	@Lob
	@Nullable
	private String description;
	
	@Column(name = "url")
	@URL(message="URL non valido")
	@NotBlank(message = "L'URL non può essere vuoto")
	private String imgUrl;
	
	@Nullable
	@Column(name = "tag")
	private String tag;
	
	@NotNull
	@Column(name = "is_visible")
	private Boolean visible;
	
	@ManyToMany
	@Nullable
	@JsonIgnore
	private List<Category> categories;
	
	@OneToMany(mappedBy = "photo", cascade = CascadeType.REMOVE)
	private List<Comment> comments;
	
	
	public Photo (){}
	public Photo (String title, String description, String imgUrl, String tag, Boolean visible) {
		setTitle(title);
		setDescription(description);
		setImgUrl(imgUrl);
		setTag(tag);
		setVisible(visible);
	}
	
	public Photo(String title, String description, String imgUrl, String tag, Boolean visible, List<Category> categories) {
		this(title, description, imgUrl, tag, visible);
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
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
	
		return "Foto: (" +  getId() + ")" + " - " + getTitle() +
				 "\nDescrizione: " + getDescription() +
				 "\nURL: " + getImgUrl() +
				 "\nTag: " + getTag() +
				 "\nVisibile?: " + getVisible();
	}
}
