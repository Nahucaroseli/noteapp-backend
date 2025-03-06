package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.NoteDTO;
import com.example.demo.model.Note;


public interface INService {
	
	List<Note> getNotes();
	
	
	Note addNote(NoteDTO n);
	Note editNote(Note n);
	void deleteNote(Long id);
	Note archiveNote(Note n);
	Optional<Note> getNote(Long id);
	
	

}
