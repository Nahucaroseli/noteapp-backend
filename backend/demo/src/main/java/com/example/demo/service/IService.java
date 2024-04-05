package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Note;


public interface IService {
	
	List<Note> getNotes();
	
	
	Note addNote(Note n);
	Note editNote(Note n);
	void deleteNote(Long id);
	Note archiveNote(Note n);
	
	
	
	

}
