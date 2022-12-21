package org.generation.italy.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pojo.Role;
import org.generation.italy.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleService {
	
	@Autowired
	RoleRepo rR;
	
	public void save(Role role) {
		rR.save(role);
	}
	
	public void delete(Role role) {
		rR.delete(role);
	}
	
	public Optional <Role> findById(int id){
		return rR.findById(id);
	}
	
	public List<Role> findAll(){
		return rR.findAll();
	}
}
