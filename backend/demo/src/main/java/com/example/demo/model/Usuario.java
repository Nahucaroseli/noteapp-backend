package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Note> notes;
	
	
	
	public Usuario(Long id, String username, String password, List<Note> notes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.notes = notes;
	}

	
	
	public List<Note> getNotes() {
		return notes;
	}



	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}



	public Usuario() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
