package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Note {
	
	@Id
	private Long id;
	private String title;
	private String description;
	private boolean archived;
	private List<String> categories;
	
	
	public Note() {
		super();
	}
	
	
	public Note(Long id, String title, String description,boolean archived
			,ArrayList<String> list) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.archived = archived;
		this.categories = list;
	}


	public Long getId() {
		return id;
	}
	
	
	


	public List<String> getCategories() {
		return categories;
	}


	public void setCategories(List<String> categories) {
		this.categories = categories;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isArchived() {
		return archived;
	}


	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	
	
	
	
	
	

}
