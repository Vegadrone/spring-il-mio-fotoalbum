package org.generation.italy.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pojo.User;
import org.generation.italy.repo.UserRepo;
import org.generation.italy.security.DatabaseUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepo uR;
	
	public void save(User user) {
		uR.save(user);
	}
	
	public void delete(User user) {
		uR.delete(user);
	}
	
	public Optional <User> findById(int id){
		return uR.findById(id);
	}
	
	public List <User> findAll(){
		return uR.findAll();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> uOpt = uR.findByUsername(username);
		if (uOpt.isEmpty()) throw new UsernameNotFoundException("User not found");
		return new DatabaseUserDetails(uOpt.get());
	}
}
