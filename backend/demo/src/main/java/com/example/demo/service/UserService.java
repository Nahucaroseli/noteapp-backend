package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	
//	
//	public Usuario deleteUserById(Long id) {
//		Usuario usuario = repository.findById(id).get();
//		if(usuario!=null) {
//			repository.deleteById(id);
//			return usuario;
//		}
//		return null;
//	}

	public Usuario register(Usuario u) {
		System.out.println(u.getUsername());
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		return repository.save(u);
	}

	public Usuario getUserById(Long id) {
		return repository.findById(id).get();
	}
	
	public Usuario signIn(Usuario u) {
		Optional<Usuario> usuario = repository.getUserByUsername(u.getUsername());
		if(u.getPassword().equals(u.getPassword())) {
			System.out.println(usuario.get().getUsername());
			return usuario.get();
		}
		return null;
		
	}
	
	

}
