package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Usuario;




public class NoteDTO {
	
	private Long id;
	private String title;
	private String description;
	private boolean archived;
	private List<String> categories;
	
	private Long usuario_id;
	
	
	public NoteDTO() {
		super();
	}
	
	
	
	
	public Long getId() {
		return id;
	}




	public String getTitle() {
		return title;
	}




	public String getDescription() {
		return description;
	}




	public boolean isArchived() {
		return archived;
	}




	public List<String> getCategories() {
		return categories;
	}




	public Long getUsuario_id() {
		return usuario_id;
	}




	public NoteDTO(Long id, String title, String description,boolean archived
			,ArrayList<String> list, Long usuario) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.archived = archived;
		this.categories = list;
		this.usuario_id = usuario;
	}

}
