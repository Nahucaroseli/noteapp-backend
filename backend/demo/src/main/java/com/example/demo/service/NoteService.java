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
public class NoteService implements INService{
	
	private NoteRepository repo;
	
	@Autowired
	private UserService userService;
	
	
	public NoteService(NoteRepository r) {
		this.repo = r;
	}
	

	@Override
	public List<Note> getNotes() {

		return repo.findAll();
	}

	@Override
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

	@Override
	public Note editNote(Note n) {
		
		return repo.save(n);
	}

	@Override
	public void deleteNote(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Note archiveNote(Note n) {
		return repo.save(n);
	}


	@Override
	public Optional<Note> getNote(Long id) {

		return repo.findById(id);
	}

}
