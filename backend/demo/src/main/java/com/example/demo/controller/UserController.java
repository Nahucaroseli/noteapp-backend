package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/users")
	public List<Usuario> getUsers(){
		return service.getUsers();
	}
	
	

	@GetMapping("/users/{id}")
	public Usuario getUserById(@PathVariable Long id){
		return service.getUserById(id);
	}
	
	@PostMapping("/users")
	public Usuario register(@RequestBody Usuario u) {
		return service.register(u);
			
	}
	

}
