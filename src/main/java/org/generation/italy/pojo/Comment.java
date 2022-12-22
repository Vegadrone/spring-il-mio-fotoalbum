package org.generation.italy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Lob
	@Nullable
	@Column
	private String text;
	
	@ManyToOne
	@JoinColumn(name="photo_id", nullable= true)
	@JsonIgnore
	private Photo photo;
	
	public Comment() {}
	public Comment(String text, Photo photo) {
		setText(text);
		setPhoto(photo);
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
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "(" + getId() + ") " + getText();
	}
}
