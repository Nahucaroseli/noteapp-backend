package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Note;
import com.example.demo.model.Usuario;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{

	@Query("SELECT n FROM Note n WHERE n.usuario=:id")
	List<Note> getNotesByUserId(@Param("id") Usuario id);

}
