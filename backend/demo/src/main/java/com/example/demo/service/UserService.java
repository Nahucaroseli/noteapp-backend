package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	private UserRepository repository;
	
	
	
	
	public List<Usuario> getUsers(){
		return repository.findAll();
	}

	public Usuario register(Usuario u) {
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		return repository.save(u);
	}

	public Usuario getUserById(Long id) {
		return repository.findById(id).get();
	}
	
	

}
