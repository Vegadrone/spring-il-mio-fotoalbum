package org.generation.italy.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pojo.Category;
import org.generation.italy.pojo.Photo;
import org.generation.italy.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo cR;
	
	public void save (Category category) {
		cR.save(category);
	}
	
	public List<Category> findAll(){
		return cR.findAll();
	}
	
	public Optional<Category> findCategoryById(int id){
		return cR.findById(id);
	}
	
	public void delete (Category category) {
		cR.delete(category);
	}
}
