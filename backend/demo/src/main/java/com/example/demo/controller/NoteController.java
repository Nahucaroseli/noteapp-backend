package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;


@RestController
@CrossOrigin("*")
public class NoteController {
	
	private NoteService service;
	
	public NoteController(NoteService s) {
		this.service = s;
	}
	
	
	@GetMapping("/notes")
	public List<Note> getNotes(){
		return service.getNotes();
	}
	
	@GetMapping("/notes/{id}")
	public Optional<Note> getNoteById(@PathVariable Long id) {
		return this.service.getNote(id);
	}
	
	@PostMapping
	public Note addNote(@RequestBody Note n) {
		return this.service.addNote(n);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable Long id) {
		this.service.deleteNote(id);
	}
	
	@PutMapping("/{id}")
	public Note editNote(@RequestBody Note n) {
		return this.service.editNote(n);
	}
	
	
	
	
	
	

}
