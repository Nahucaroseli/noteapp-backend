package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Note;
import com.example.demo.repository.Repo;


@Service
public class NoteService implements IService{
	
	private Repo repo;
	
	
	public NoteService(Repo r) {
		this.repo = r;
	}
	

	@Override
	public List<Note> getNotes() {

		return repo.findAll();
	}

	@Override
	public Note addNote(Note n) {
		return repo.save(n);
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

}
