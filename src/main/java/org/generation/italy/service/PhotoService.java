package org.generation.italy.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pojo.Photo;
import org.generation.italy.repo.PhotoRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepo pR;
	
	public void save(Photo photo) {
		pR.save(photo);
	}
	
	public List<Photo> findAll(){
		return pR.findAll();
	}
	
	public Optional<Photo> findPhotoById(int id){
		return pR.findById(id);
	}
	
	public void delete (Photo photo) {
		pR.delete(photo);
	}
	
	public void deleteById (int id) {
		pR.deleteById(id);
	}
	
	public List<Photo> findByNameOrTag(String query) {
		return pR.findByTitleContainingOrTagContaining(query, query);
	}
	
	@Transactional
	public List<Photo> findAllWCategory(){
		List<Photo> photos= pR.findAll();
		
		for(Photo photo :photos) {
			Hibernate.initialize(photo.getCategories());
		}
		
		return photos;
	}
}
