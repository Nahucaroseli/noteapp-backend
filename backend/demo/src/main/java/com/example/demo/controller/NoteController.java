package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.NoteDTO;
import com.example.demo.model.Note;
import com.example.demo.service.NoteService;


@RestController
@CrossOrigin("*")
public class NoteController {
	
	@Autowired
	private NoteService service;
	
	
	
	@GetMapping("/users/{id_usuario}/notes")
	public List<Note> getNotesByUserId(@PathVariable Long id_usuario){
		return service.getNotesByUserId(id_usuario);
	}
	
	@GetMapping("/notes/{id}")
	public Optional<Note> getNoteById(@PathVariable Long id) {
		return this.service.getNote(id);
	}
	
	@PostMapping("/notes")
	public Note addNote(@RequestBody NoteDTO n) {
		return this.service.addNote(n);
	}
	
	
	@GetMapping("/notes/total")
	public int getNotesTotal() {
		return this.service.getNotesTotal();
	}
	
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@PathVariable Long id) {
		this.service.deleteNote(id);
	}
	
	@PutMapping("/notes/{id}")
	public Note editNote(@RequestBody Note n) {
		return this.service.editNote(n);
	}
	
	
	
	
	
	

}
