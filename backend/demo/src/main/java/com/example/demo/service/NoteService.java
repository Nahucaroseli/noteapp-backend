package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.NoteDTO;
import com.example.demo.model.Note;
import com.example.demo.model.Usuario;
import com.example.demo.repository.NoteRepository;


@Service
public class NoteService{
	
	@Autowired
	private NoteRepository repo;
	
	@Autowired
	private UserService userService;
	


	public List<Note> getNotesByUserId(Long id) {
		Usuario usuario = userService.getUserById(id);
		if(usuario!=null) {
			return repo.getNotesByUserId(usuario);
		}
		return null;
	}


	public Note addNote(NoteDTO n) {
		Usuario user = userService.getUserById(n.getUsuario_id());
		if(user!=null) {
			Note nueva = new Note();
			nueva.setUsuario(user);
			nueva.setArchived(n.isArchived());
			nueva.setCategories(n.getCategories());
			nueva.setDescription(n.getDescription());
			nueva.setTitle(n.getTitle());
			return repo.save(nueva);
		}
		return null;
	}


	public Note editNote(Note n) {
		
		return repo.save(n);
	}


	public void deleteNote(Long id) {
		repo.deleteById(id);
	}


	public Note archiveNote(Note n) {
		return repo.save(n);
	}



	public Optional<Note> getNote(Long id) {

		return repo.findById(id);
	}


	public int getNotesTotal() {
		return repo.getNotesTotal();
	}


	public List<Note> getNotes() {
		return repo.findAll();
	}

}
